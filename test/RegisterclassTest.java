import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterclassTest {
    @Test
    public void testRegisterFieldsSet() {
        Registerclass reg = new Registerclass("Alice", "Smith", "alice01", "password", "0821234567");
        assertEquals("Alice", reg.getFirstName());
        assertEquals("Smith", reg.getLastName());
        assertEquals("alice01", reg.getUsername());
        assertEquals("password", reg.getPassword());
        assertEquals("0821234567", reg.getCellNumber());
    }

    @Test
    public void testInvalidCellNumber() {
        Registerclass reg = new Registerclass("Bob", "Jones", "bobj", "pass", "12345");
        assertFalse(reg.isCellNumberValid());
    }

    @Test
    public void testValidCellNumber() {
        Registerclass reg = new Registerclass("Bob", "Jones", "bobj", "pass", "+27821234567");
        assertTrue(reg.isCellNumberValid());
    }
}