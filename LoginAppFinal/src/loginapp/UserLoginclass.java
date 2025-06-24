package loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserLoginclass extends JPanel {

    public UserLoginclass() {
        initComponents();
    }

    public void addConfirmButtonListener(ActionListener listener) {
        Confirm.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        Back.addActionListener(listener);
    }

    public String getUsername() {
        return UsernameField.getText();
    }

    public String getPassword() {
        return new String(PasswordField.getPassword());
    }

    private void initComponents() {
        // Set panel layout and background
        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 245)); // Light gray background

        // Create labels and fields
        JLabel titleLabel = new JLabel("User Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204)); // Dark blue

        JLabelUsername = new JLabel("Username:");
        JLabelPassword = new JLabel("Password:");

        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);

        Confirm = new JButton("Login");
        Back = new JButton("Back");

        // Style buttons
        Confirm.setBackground(new Color(0, 204, 102)); // Green
        Confirm.setForeground(Color.WHITE);
        Confirm.setFont(new Font("Arial", Font.BOLD, 14));

        Back.setBackground(new Color(204, 0, 0)); // Red
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Arial", Font.BOLD, 14));

        // Add components to the panel with layout management
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.gridx = 0;
        add(JLabelUsername, gbc);
        gbc.gridx = 1;
        add(UsernameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        add(JLabelPassword, gbc);
        gbc.gridx = 1;
        add(PasswordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        add(Back, gbc);
        gbc.gridx = 1;
        add(Confirm, gbc);
    }

    private JButton Back, Confirm;
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JLabel JLabelUsername, JLabelPassword;
}