package loginapp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        Welcomeclass welcomePanel = new Welcomeclass();
        Registerclass registerPanel = new Registerclass();
        UserLoginclass userLoginPanel = new UserLoginclass();

        mainPanel.add(welcomePanel, "Welcome");
        mainPanel.add(registerPanel, "Register");
        mainPanel.add(userLoginPanel, "UserLogin");

        Login login = new Login();

        // Welcome panel listeners
        welcomePanel.addRegisterButtonListener(e -> cardLayout.show(mainPanel, "Register"));
        welcomePanel.addLoginButtonListener(e -> cardLayout.show(mainPanel, "UserLogin"));

        // Register panel listeners
        registerPanel.addConfirmButtonListener(e -> {
            String firstName = registerPanel.getFirstName();
            String lastName = registerPanel.getLastName();
            String username = registerPanel.getUsername();
            String password = registerPanel.getPassword();
            String cellNumber = registerPanel.getPhoneNumber();
            if (cellNumber.matches("^\\d{10}$")) cellNumber = "+27" + cellNumber.substring(1);
            String message = login.registerUser(username, password, cellNumber, firstName, lastName);
            JOptionPane.showMessageDialog(frame, message);
            if (message.equals("User successfully registered.")) cardLayout.show(mainPanel, "UserLogin");
        });
        registerPanel.addBackButtonListener(e -> cardLayout.show(mainPanel, "Welcome"));

        // Login panel listeners
        userLoginPanel.addConfirmButtonListener(e -> {
            String username = userLoginPanel.getUsername();
            String password = userLoginPanel.getPassword();
            boolean isValid = login.loginUser(username, password);
            JOptionPane.showMessageDialog(frame, login.returnLoginStatus(isValid));
            if (isValid) {
                JOptionPane.showMessageDialog(frame, "Welcome to QuickChat.");
                runMessagingSystem(frame);
            }
        });
        userLoginPanel.addBackButtonListener(e -> cardLayout.show(mainPanel, "Welcome"));

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // --- START PART 2: Minimal message system code below ---

    private static void runMessagingSystem(JFrame frame) {
        while (true) {
            String menu = "Main Menu\n1. Send Message\n2. Show Recently Sent Messages (Coming Soon)\n3. Quit";
            String input = JOptionPane.showInputDialog(frame, menu, "QuickChat Menu", JOptionPane.PLAIN_MESSAGE);
            if (input == null || input.trim().equals("3")) {
                JOptionPane.showMessageDialog(frame, "Total messages sent: " + Message.returnTotalMessages());
                break;
            }
            if (input.trim().equals("1")) handleSendMessages(frame);
            else JOptionPane.showMessageDialog(frame, "Feature coming soon.");
        }
    }

    private static void handleSendMessages(JFrame frame) {
        int howMany = 0;
        while (howMany <= 0) {
            String num = JOptionPane.showInputDialog(frame, "How many messages to send?", "Number", JOptionPane.PLAIN_MESSAGE);
            if (num == null) return;
            try { howMany = Integer.parseInt(num.trim()); } catch (Exception ignored) {}
        }
        for (int i = 1; i <= howMany; i++) {
            String cell = JOptionPane.showInputDialog(frame, "Enter recipient cell number (e.g. 0823456789 or +27712345678):", "Recipient", JOptionPane.PLAIN_MESSAGE);
            if (cell == null) return;
            String text = JOptionPane.showInputDialog(frame, "Enter your message (max 250 chars):", "Compose", JOptionPane.PLAIN_MESSAGE);
            if (text == null) return;

            Message msgObj = new Message(cell, text);

            String lengthStatus = msgObj.checkMessageLength();
            if (!lengthStatus.equals("Message ready to send.")) {
                JOptionPane.showMessageDialog(frame, lengthStatus);
                i--; continue;
            }

            if (msgObj.checkRecipientCell() == 1)
                JOptionPane.showMessageDialog(frame, "Cell phone number successfully captured.");
            else {
                JOptionPane.showMessageDialog(frame, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                i--; continue;
            }

            JOptionPane.showMessageDialog(frame, "Message ID generated: " + msgObj.getMessageID());
            JOptionPane.showMessageDialog(frame, "Message Hash: " + msgObj.getMessageHash());

            Object[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
            int choice = JOptionPane.showOptionDialog(frame, "Choose an action for this message:",
                    "Message Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            String result = "";
            if (choice == 0) {
                result = msgObj.sendMessage(1);
                JOptionPane.showMessageDialog(frame,
                        "Message sent.\nMessage ID: " + msgObj.getMessageID() +
                                "\nMessage Hash: " + msgObj.getMessageHash() +
                                "\nRecipient: " + msgObj.getRecipientCellNo() +
                                "\nMessage Text: " + msgObj.getMessageText());
            } else if (choice == 1) result = msgObj.sendMessage(2);
            else if (choice == 2) result = msgObj.sendMessage(3);
            if (!result.isEmpty()) JOptionPane.showMessageDialog(frame, result);
        }
    }
}