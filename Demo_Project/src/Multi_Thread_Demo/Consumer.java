package Multi_Thread_Demo;

public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final int consumerId;

    public Consumer(SharedBuffer buffer, int consumerId) {
        this.buffer = buffer;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Consume 10 items
                int item = buffer.consume();
                System.out.println("Consumer " + consumerId + " consumed: " + item);
                Thread.sleep((int) (Math.random() * 100)); // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
