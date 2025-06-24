package loginapp;

import java.util.regex.*;

public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String firstName;
    private String lastName;

    /**
     * Validates the username.
     * The username must contain an underscore and be no more than 5 characters long.
     *
     * @param username The username to validate.
     * @return True if the username is valid, false otherwise.
     */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Validates the password complexity.
     * The password must contain at least 8 characters, a capital letter, a number, and a special character.
     *
     * @param password The password to validate.
     * @return True if the password is valid, false otherwise.
     */
    public boolean checkPasswordComplexity(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";
        return Pattern.compile(passwordPattern).matcher(password).matches();
    }

    /**
     * Validates the cell number format.
     * The cell number must start with '+' and contain between 10 and 13 digits.
     *
     * @param cellNumber The cell number to validate.
     * @return True if the cell number is valid, false otherwise.
     */
    public boolean checkCellNumber(String cellNumber) {
        String cellNumberPattern = "^\\+\\d{10,13}$";
        return Pattern.compile(cellNumberPattern).matcher(cellNumber).matches();
    }

    /**
     * Registers a new user.
     * Validates the username, password, and cell number before storing them.
     *
     * @param username   The username of the user.
     * @param password   The password for the user.
     * @param cellNumber The cell number for the user.
     * @param firstName  The user's first name.
     * @param lastName   The user's last name.
     * @return A message indicating whether registration was successful or why it failed.
     */
    public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Ensure it contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellNumber(cellNumber)) {
            return "Cell number is incorrectly formatted. Ensure it includes an international code and is valid.";
        }

        // Store user details
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellNumber = cellNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        return "User successfully registered.";
    }

    /**
     * Logs in an existing user by validating the username and password.
     *
     * @param username The username provided by the user.
     * @param password The password provided by the user.
     * @return True if the username and password match, false otherwise.
     */
    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    /**
     * Returns a login status message.
     *
     * @param loginSuccessful Whether the login attempt was successful.
     * @return A message indicating the login status.
     */
    public String returnLoginStatus(boolean loginSuccessful) {
        return loginSuccessful
            ? "Welcome back, " + this.firstName + " " + this.lastName + "!"
            : "Invalid username or password. Please try again.";
    }
}