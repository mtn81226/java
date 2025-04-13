public class BreadConsumer extends Thread {
    private final BreadBuffer buffer;
    private volatile boolean running = true;

    public BreadConsumer(BreadBuffer buffer) {
        this.buffer = buffer;
    }

    public void stopConsuming() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                buffer.consumeBread();
                sleep(150); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}