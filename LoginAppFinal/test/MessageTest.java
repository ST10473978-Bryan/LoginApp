import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {
    @Test
    public void testMessageIDLength() {
        Message msg = new Message("0821234567", "Test message");
        assertEquals(10, msg.getMessageID().length());
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testRecipientCellValidation() {
        Message msg1 = new Message("0821234567", "Hi");
        Message msg2 = new Message("+27821234567", "Hi");
        Message msg3 = new Message("123456", "Hi");
        assertEquals(1, msg1.checkRecipientCell());
        assertEquals(1, msg2.checkRecipientCell());
        assertEquals(0, msg3.checkRecipientCell());
    }

    @Test
    public void testMessageLengthCheck() {
        Message msg = new Message("0821234567", "A".repeat(251));
        assertTrue(msg.checkMessageLength().contains("exceeds 250 characters"));
    }

    @Test
    public void testSendMessageOption1() {
        Message msg = new Message("0821234567", "Test");
        String resp = msg.sendMessage(1);
        assertEquals("Message successfully sent.", resp);
    }
}