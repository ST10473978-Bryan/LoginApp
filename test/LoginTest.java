import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    @Test
    public void testRegisterAndLoginUserSuccess() {
        Login login = new Login();
        String regResult = login.registerUser("user", "pass", "+27821234567", "Jane", "Doe");
        assertEquals("User successfully registered.", regResult);
        assertTrue(login.loginUser("user", "pass"));
    }

    @Test
    public void testRegisterDuplicateUser() {
        Login login = new Login();
        login.registerUser("user", "pass", "+27821234567", "Jane", "Doe");
        String result = login.registerUser("user", "pass2", "+27821234567", "Jane", "Doe");
        assertEquals("Username already exists.", result);
    }

    @Test
    public void testLoginInvalidCredentials() {
        Login login = new Login();
        login.registerUser("user", "pass", "+27821234567", "Jane", "Doe");
        assertFalse(login.loginUser("user", "wrongpass"));
    }

    @Test
    public void testReturnLoginStatusMessages() {
        Login login = new Login();
        assertEquals("Login successful.", login.returnLoginStatus(true));
        assertEquals("Login failed.", login.returnLoginStatus(false));
    }
}