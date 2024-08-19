package Multi_Thread_Demo;

public class Main {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer size of 5

        Thread producer1 = new Thread(new Producer(buffer, 1));
        Thread producer2 = new Thread(new Producer(buffer, 2));
        Thread consumer1 = new Thread(new Consumer(buffer, 1));
        Thread consumer2 = new Thread(new Consumer(buffer, 2));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
