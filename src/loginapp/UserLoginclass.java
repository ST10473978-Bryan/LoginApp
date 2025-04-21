package loginapp;

import java.awt.event.ActionListener;

public class UserLoginclass extends javax.swing.JPanel {

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
        JLabelUsername = new javax.swing.JLabel();
        JLabelPassword = new javax.swing.JLabel();

        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();

        Confirm = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        // Set text for labels
        JLabelUsername.setText("Username:");
        JLabelPassword.setText("Password:");

        Confirm.setText("Confirm");
        Back.setText("Back");

        // Layout design
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelUsername)
                            .addGap(18)
                            .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelPassword)
                            .addGap(18)
                            .addComponent(PasswordField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30)
                            .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(30))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelUsername)
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelPassword)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
        );
    }

    private javax.swing.JButton Back;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPasswordField PasswordField;

    private javax.swing.JLabel JLabelUsername;
    private javax.swing.JLabel JLabelPassword;
}