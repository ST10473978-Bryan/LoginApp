package loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Registerclass extends JPanel {

    public Registerclass() {
        initComponents();
    }

    public void addConfirmButtonListener(ActionListener listener) {
        Confirm.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        Back.addActionListener(listener);
    }

    public String getFirstName() {
        return FirstNameField.getText();
    }

    public String getLastName() {
        return LastNameField.getText();
    }

    public String getUsername() {
        return UsernameField.getText();
    }

    public String getPassword() {
        return new String(PasswordField.getPassword());
    }

    public String getPhoneNumber() {
        return PhoneNumberField.getText();
    }

    private void initComponents() {
        // Set panel layout and background
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 248, 255)); // Light blue background

        // Create labels and fields
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204)); // Dark blue

        JLabelFirstName = new JLabel("First Name:");
        JLabelLastName = new JLabel("Last Name:");
        JLabelUsername = new JLabel("Username:");
        JLabelPassword = new JLabel("Password:");
        JLabelPhoneNumber = new JLabel("Phone Number:");

        FirstNameField = new JTextField(15);
        LastNameField = new JTextField(15);
        UsernameField = new JTextField(15);
        PasswordField = new JPasswordField(15);
        PhoneNumberField = new JTextField(15);

        Confirm = new JButton("Confirm");
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
        add(JLabelFirstName, gbc);
        gbc.gridx = 1;
        add(FirstNameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        add(JLabelLastName, gbc);
        gbc.gridx = 1;
        add(LastNameField, gbc);

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
        add(JLabelPhoneNumber, gbc);
        gbc.gridx = 1;
        add(PhoneNumberField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        add(Back, gbc);
        gbc.gridx = 1;
        add(Confirm, gbc);
    }

    private JButton Back, Confirm;
    private JTextField FirstNameField, LastNameField, UsernameField, PhoneNumberField;
    private JPasswordField PasswordField;
    private JLabel JLabelFirstName, JLabelLastName, JLabelUsername, JLabelPassword, JLabelPhoneNumber;
}