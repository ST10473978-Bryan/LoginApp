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
            String menu = "Main Menu\n1. Send Message\n2. Show Recently Sent Messages\n3. Quit";
            String input = JOptionPane.showInputDialog(frame, menu, "QuickChat Menu", JOptionPane.PLAIN_MESSAGE);
            if (input == null || input.trim().equals("3")) {
                JOptionPane.showMessageDialog(frame, "Total messages sent: " + Message.returnTotalMessages());
                break;
            }
            if (input.trim().equals("1")) handleSendMessages(frame);
            else if (input.trim().equals("2")) runArraysMenu(frame);
            else JOptionPane.showMessageDialog(frame, "Invalid option.");
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

    // --- START PART 3: Arrays (Tasks) menu below ---

    private static void runArraysMenu(JFrame frame) {
        while (true) {
            String menu =
                    "Tasks Menu\n" +
                    "1. Display all tasks\n" +
                    "2. Display done tasks (Developer, Name, Duration)\n" +
                    "3. Display Developer & Duration of the longest task\n" +
                    "4. Search for a task by Task Name\n" +
                    "5. Search all tasks by Developer\n" +
                    "6. Delete a task by Task Name\n" +
                    "7. Display full tasks report\n" +
                    "8. Back to QuickChat Menu";
            String input = JOptionPane.showInputDialog(frame, menu, "Tasks Menu", JOptionPane.PLAIN_MESSAGE);
            if (input == null || input.trim().equals("8")) break;

            switch (input.trim()) {
                case "1":
                    JOptionPane.showMessageDialog(frame, ArrayManager.getFullReport());
                    break;
                case "2": {
                    StringBuilder sb = new StringBuilder("*** DONE TASKS ***\n");
                    for (ArrayTask t : ArrayManager.getTasksByStatus("Done")) {
                        sb.append("Developer: ").append(t.getDeveloper())
                            .append(" | Name: ").append(t.getTaskName())
                            .append(" | Duration: ").append(t.getDuration()).append("\n");
                    }
                    if (sb.toString().equals("*** DONE TASKS ***\n"))
                        sb.append("No done tasks found.\n");
                    JOptionPane.showMessageDialog(frame, sb.toString());
                    break;
                }
                case "3": {
                    ArrayTask t = ArrayManager.getLongestDurationTask();
                    if (t != null)
                        JOptionPane.showMessageDialog(frame, "Developer: " + t.getDeveloper() + "\nDuration: " + t.getDuration());
                    else
                        JOptionPane.showMessageDialog(frame, "No tasks found.");
                    break;
                }
                case "4": {
                    String taskName = JOptionPane.showInputDialog(frame, "Enter Task Name to search:");
                    if (taskName == null) break;
                    ArrayTask t = ArrayManager.getTaskByName(taskName);
                    if (t != null)
                        JOptionPane.showMessageDialog(frame, t.toString());
                    else
                        JOptionPane.showMessageDialog(frame, "Task not found.");
                    break;
                }
                case "5": {
                    String dev = JOptionPane.showInputDialog(frame, "Enter Developer Name to search:");
                    if (dev == null) break;
                    StringBuilder sb = new StringBuilder("*** TASKS FOR " + dev + " ***\n");
                    for (ArrayTask t : ArrayManager.getTasksByDeveloper(dev)) {
                        sb.append("Task Name: ").append(t.getTaskName())
                            .append(" | Status: ").append(t.getStatus()).append("\n");
                    }
                    if (sb.toString().endsWith("*** TASKS FOR " + dev + " ***\n"))
                        sb.append("No tasks for this developer.\n");
                    JOptionPane.showMessageDialog(frame, sb.toString());
                    break;
                }
                case "6": {
                    String taskName = JOptionPane.showInputDialog(frame, "Enter Task Name to delete:");
                    if (taskName == null) break;
                    boolean deleted = ArrayManager.deleteTaskByName(taskName);
                    if (deleted)
                        JOptionPane.showMessageDialog(frame, "Entry \"" + taskName + "\" successfully deleted.");
                    else
                        JOptionPane.showMessageDialog(frame, "Task not found.");
                    break;
                }
                case "7":
                    JOptionPane.showMessageDialog(frame, ArrayManager.getFullReport());
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Invalid option.");
            }
        }
    }
}