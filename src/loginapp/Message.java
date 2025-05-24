package loginapp;

import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Message {
    private String messageID;
    private String recipientCellNo;
    private String messageText;
    private String messageHash;

    private static List<Message> sentMessages = new ArrayList<>();
    private static List<Message> storedMessages = new ArrayList<>();
    private static final int MESSAGE_LIMIT = 250;

    public Message(String recipientCellNo, String messageText) {
        this.messageID = generateMessageID();
        this.recipientCellNo = recipientCellNo;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }

    public int checkRecipientCell() {
        if(recipientCellNo == null) return 0;
        if(recipientCellNo.matches("^0\\d{9}$") || recipientCellNo.matches("^\\+27\\d{9}$")) {
            return 1;
        }
        return 0;
    }

    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2) return "";
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        int wordCount = messageText.trim().isEmpty() ? 0 : words.length;
        String firstWord = wordCount > 0 ? words[0] : "";
        String lastWord = wordCount > 0 ? words[words.length - 1] : "";
        return String.format("%s:%d;%s%s", firstTwo, wordCount, firstWord, lastWord).toUpperCase();
    }

    public String sendMessage(int option) {
        switch(option) {
            case 1:
                sentMessages.add(this);
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete message.";
            case 3:
                storedMessages.add(this);
                storeMessagesToJson();
                return "Message successfully stored.";
            default:
                return "Invalid option.";
        }
    }

    public String checkMessageLength() {
        if(messageText.length() > MESSAGE_LIMIT) {
            int diff = messageText.length() - MESSAGE_LIMIT;
            return "Message exceeds 250 characters by " + diff + ", please reduce size.";
        }
        return "Message ready to send.";
    }

    public static String printMessages() {
        StringBuilder sb = new StringBuilder();
        for(Message m : sentMessages) {
            sb.append("Message ID: ").append(m.messageID).append("\n");
            sb.append("Message Hash: ").append(m.messageHash).append("\n");
            sb.append("Recipient: ").append(m.recipientCellNo).append("\n");
            sb.append("Message Text: ").append(m.messageText).append("\n\n");
        }
        return sb.toString();
    }

    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    private void storeMessagesToJson() {
        try (FileWriter writer = new FileWriter("stored_messages.json")) {
            Gson gson = new Gson();
            gson.toJson(storedMessages, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadStoredMessagesFromJson() {
        try {
            File file = new File("stored_messages.json");
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    Gson gson = new Gson();
                    storedMessages = gson.fromJson(reader, new TypeToken<List<Message>>(){}.getType());
                    if (storedMessages == null) storedMessages = new ArrayList<>();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMessageID() { return messageID; }
    public String getRecipientCellNo() { return recipientCellNo; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
}