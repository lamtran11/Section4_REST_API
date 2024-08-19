package Multi_Thread_Demo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedBuffer {
    private final BlockingQueue<Integer> buffer;

    public SharedBuffer(int size) {
        buffer = new LinkedBlockingQueue<>(size);
    }

    public void produce(int item) throws InterruptedException {
        buffer.put(item);
    }

    public int consume() throws InterruptedException {
        return buffer.take();
    }
}
