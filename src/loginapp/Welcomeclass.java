package loginapp;

import java.awt.event.ActionListener;

public class Welcomeclass extends javax.swing.JPanel {

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
        Welcome = new javax.swing.JLabel();
        Register = new javax.swing.JButton();
        Login = new javax.swing.JButton();

        Welcome.setFont(new java.awt.Font("Arial", 1, 24));
        Welcome.setText("Welcome");

        Register.setFont(new java.awt.Font("Arial", 0, 20));
        Register.setText("Register");

        Login.setFont(new java.awt.Font("Arial", 0, 20));
        Login.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(Welcome)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(50)
                .addComponent(Welcome)
                .addGap(30)
                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }

    private javax.swing.JButton Login;
    private javax.swing.JButton Register;
    private javax.swing.JLabel Welcome;
}