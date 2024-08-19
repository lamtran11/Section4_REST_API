package Multi_Thread_Demo;

public class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final int producerId;

    public Producer(SharedBuffer buffer, int producerId) {
        this.buffer = buffer;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Produce 10 items
                int item = producerId * 10 + i; // Unique item per producer
                buffer.produce(item);
                System.out.println("Producer " + producerId + " produced: " + item);
                Thread.sleep((int) (Math.random() * 100)); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
