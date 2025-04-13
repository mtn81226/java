public class TicketSeller extends Thread {
    private final TicketBuffer buffer;
    private volatile boolean running = true;

    public TicketSeller(TicketBuffer buffer) {
        this.buffer = buffer;
    }

    public void stopSelling() {
        running = false;
    }

    @Override
    public void run() {
        int ticket = 0;
        while (running) {
            try {
                buffer.sellTicket(ticket++);
                sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
