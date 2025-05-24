import org.junit.Test;
import static org.junit.Assert.*;

public class UserLoginclassTest {
    @Test
    public void testSetAndGetUsernamePassword() {
        UserLoginclass user = new UserLoginclass();
        user.setUsername("tester");
        user.setPassword("secure123");
        assertEquals("tester", user.getUsername());
        assertEquals("secure123", user.getPassword());
    }

    @Test
    public void testValidateLogin() {
        UserLoginclass user = new UserLoginclass();
        user.setUsername("john");
        user.setPassword("pass");
        assertTrue(user.validateLogin("john", "pass"));
        assertFalse(user.validateLogin("john", "wrong"));
    }
}