package src.Server;

import src.bin.*;
import src.Server.*;

public class MessageEntry implements ServerApplicationInterface {
    private MessageQueue messageQueue;

    public MessageEntry(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void handleMessage(Message message, String connectionId) {
        MessageWrapper wrapper = new MessageWrapper((ClientMessage)message, connectionId);
        messageQueue.append(wrapper);
    }
}
