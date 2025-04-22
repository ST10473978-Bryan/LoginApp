package loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Welcomeclass extends JPanel {

    public Welcomeclass() {
        initComponents();
    }

    public void addRegisterButtonListener(ActionListener listener) {
        Register.addActionListener(listener);
    }

    public void addLoginButtonListener(ActionListener listener) {
        Login.addActionListener(listener);
    }

    private void initComponents() {
        // Set panel layout and background
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 248, 255)); // Light blue background

        // Create components
        JLabel welcomeLabel = new JLabel("Welcome to the Login System");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 102, 204)); // Dark blue

        Register = new JButton("Register");
        Login = new JButton("Login");

        // Style buttons
        Register.setBackground(new Color(0, 204, 102)); // Green
        Register.setForeground(Color.WHITE);
        Register.setFont(new Font("Arial", Font.BOLD, 14));

        Login.setBackground(new Color(0, 102, 204)); // Blue
        Login.setForeground(Color.WHITE);
        Login.setFont(new Font("Arial", Font.BOLD, 14));

        // Layout components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Center-align
        add(welcomeLabel, gbc);

        gbc.gridwidth = 1; // Reset grid width
        gbc.gridy++;
        gbc.gridx = 0;
        add(Register, gbc);

        gbc.gridx = 1;
        add(Login, gbc);
    }

    private JButton Register;
    private JButton Login;
}