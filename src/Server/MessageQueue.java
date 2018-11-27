package src.Server;

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {

    private List<MessageWrapper> queue = new ArrayList<MessageWrapper>();

    public  synchronized void append(MessageWrapper wrapper) {
        queue.add(wrapper);
        notify();
    }

    public synchronized MessageWrapper remove() {
        if (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove(0);
    }
}
