package loginapp;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create the main application window
        JFrame frame = new JFrame("Login Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Set up a CardLayout to switch between panels
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Create instances of the different panels
        Welcomeclass welcomePanel = new Welcomeclass();
        Registerclass registerPanel = new Registerclass();
        UserLoginclass userLoginPanel = new UserLoginclass();

        // Add the panels to the main panel
        mainPanel.add(welcomePanel, "Welcome");
        mainPanel.add(registerPanel, "Register");
        mainPanel.add(userLoginPanel, "UserLogin");

        // Create an instance of the Login class for user authentication and registration
        Login login = new Login();

        // Add action listeners for the Welcome panel buttons
        welcomePanel.addRegisterButtonListener(e -> cardLayout.show(mainPanel, "Register"));
        welcomePanel.addLoginButtonListener(e -> cardLayout.show(mainPanel, "UserLogin"));

        // Add action listeners for the Register panel buttons
        registerPanel.addConfirmButtonListener(e -> {
            // Retrieve user input from the Register panel
            String firstName = registerPanel.getFirstName();
            String lastName = registerPanel.getLastName();
            String username = registerPanel.getUsername();
            String password = registerPanel.getPassword();
            String cellNumber = registerPanel.getPhoneNumber();

            // Auto-format South African cell numbers
            if (cellNumber.matches("^\\d{10}$")) {
                cellNumber = "+27" + cellNumber.substring(1);
            }

            // Attempt to register the user
            String message = login.registerUser(username, password, cellNumber, firstName, lastName);
            JOptionPane.showMessageDialog(frame, message);

            // If registration is successful, navigate to the UserLogin panel
            if (message.equals("User successfully registered.")) {
                cardLayout.show(mainPanel, "UserLogin");
            }
        });
        registerPanel.addBackButtonListener(e -> cardLayout.show(mainPanel, "Welcome"));

        // Add action listeners for the UserLogin panel buttons
        userLoginPanel.addConfirmButtonListener(e -> {
            // Retrieve user input from the UserLogin panel
            String username = userLoginPanel.getUsername();
            String password = userLoginPanel.getPassword();

            // Attempt to log in the user
            boolean isValid = login.loginUser(username, password);
            JOptionPane.showMessageDialog(frame, login.returnLoginStatus(isValid));
        });
        userLoginPanel.addBackButtonListener(e -> cardLayout.show(mainPanel, "Welcome"));

        // Add the main panel to the frame and make it visible
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}