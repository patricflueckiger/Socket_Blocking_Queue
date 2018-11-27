

import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class QueueWorker implements Runnable{
	
	BlockingQueue<TaskItem> queue;
	
	public QueueWorker(BlockingQueue<TaskItem> queue) {
        this.queue = queue;
    }
	
	@Override
	public void run() {
		while(true){
            try {
                TaskItem item = queue.take();
                executeSend(item);
            } catch (InterruptedException e) {
                System.out.println("QueueWorker -> Not item found");
                e.printStackTrace();
            }
        }
		
	}
	
	private void executeSend(TaskItem  taskItem){
        taskItem.function.accept((Socket) taskItem.function);
    }

}
