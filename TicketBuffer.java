import java.util.LinkedList;
import java.util.Queue;

public class TicketBuffer {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public TicketBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void sellTicket(int ticket) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(ticket);
        System.out.println("Ticket Sold: " + ticket);
        notifyAll();
    }

    public synchronized int buyTicket() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int ticket = queue.poll();
        System.out.println("Ticket Bought: " + ticket);
        notifyAll();
        return ticket;
    }
}
