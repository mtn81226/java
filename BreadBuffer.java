import java.util.LinkedList;
import java.util.Queue;

public class BreadBuffer {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public BreadBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produceBread(int bread) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(bread);
        System.out.println("Produced Bread: " + bread);
        notifyAll();
    }

    public synchronized int consumeBread() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int bread = queue.poll();
        System.out.println("Consumed Bread: " + bread);
        notifyAll();
        return bread;
    }
}
