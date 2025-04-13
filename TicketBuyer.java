public class TicketBuyer extends Thread {
    private final TicketBuffer buffer;
    private volatile boolean running = true;

    public TicketBuyer(TicketBuffer buffer) {
        this.buffer = buffer;
    }

    public void stopBuying() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                buffer.buyTicket();
                sleep(150); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
