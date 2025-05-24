import org.junit.Test;
import static org.junit.Assert.*;

public class WelcomeclassTest {
    @Test
    public void testWelcomeMessage() {
        Welcomeclass welcome = new Welcomeclass();
        String msg = welcome.getWelcomeMessage();
        assertTrue(msg.contains("Welcome"));
    }

    @Test
    public void testPanelOptionsPresent() {
        Welcomeclass welcome = new Welcomeclass();
        assertTrue(welcome.getPanelOptions().contains("Register"));
        assertTrue(welcome.getPanelOptions().contains("Login"));
    }
}