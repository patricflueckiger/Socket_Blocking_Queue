package src.Server;

import src.bin.*;

public class MessageWrapper {
    private ClientMessage message;

    public ClientMessage getMessage() {
        return message;
    }

    public String getConnectionId() {
        return connectionId;
    }

    private String connectionId;

    public MessageWrapper(ClientMessage message, String connectionId) {
        this.message = message;
        this.connectionId = connectionId;
    }


}
