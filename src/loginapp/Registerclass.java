package loginapp;

import java.awt.event.ActionListener;

public class Registerclass extends javax.swing.JPanel {

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
        JLabelFirstName = new javax.swing.JLabel();
        JLabelLastName = new javax.swing.JLabel();
        JLabelUsername = new javax.swing.JLabel();
        JLabelPassword = new javax.swing.JLabel();
        JLabelPhoneNumber = new javax.swing.JLabel();

        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        PhoneNumberField = new javax.swing.JTextField();

        Confirm = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        
        JLabelFirstName.setText("First Name:");
        JLabelLastName.setText("Last Name:");
        JLabelUsername.setText("Username:");
        JLabelPassword.setText("Password:");
        JLabelPhoneNumber.setText("Phone Number:");

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
                            .addComponent(JLabelFirstName)
                            .addGap(18)
                            .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelLastName)
                            .addGap(18)
                            .addComponent(LastNameField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelUsername)
                            .addGap(18)
                            .addComponent(UsernameField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelPassword)
                            .addGap(18)
                            .addComponent(PasswordField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(JLabelPhoneNumber)
                            .addGap(18)
                            .addComponent(PhoneNumberField))
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
                    .addComponent(JLabelFirstName)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelLastName)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelUsername)
                    .addComponent(UsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelPassword)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabelPhoneNumber)
                    .addComponent(PhoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
        );
    }

    private javax.swing.JButton Back;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField PhoneNumberField;

    private javax.swing.JLabel JLabelFirstName;
    private javax.swing.JLabel JLabelLastName;
    private javax.swing.JLabel JLabelUsername;
    private javax.swing.JLabel JLabelPassword;
    private javax.swing.JLabel JLabelPhoneNumber;
}