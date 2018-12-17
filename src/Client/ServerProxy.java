
package src.Client;


import src.Client.ClientApplicationInterface;
import src.bin.Message;

public abstract class ServerProxy {
    ClientApplicationInterface clientApplicationInterface;
    public ServerProxy(ClientApplicationInterface clientApplicationInterface){
            this.clientApplicationInterface = clientApplicationInterface;
    }

    public void send(Message message) {
// sockets senden
    }
}
