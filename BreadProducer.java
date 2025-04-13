public class BreadProducer extends Thread {
    private final BreadBuffer buffer;
    private volatile boolean running = true;

    public BreadProducer(BreadBuffer buffer) {
        this.buffer = buffer;
    }

    public void stopProducing() {
        running = false;
    }

    @Override
    public void run() {
        int bread = 0;
        while (running) {
            try {
                buffer.produceBread(bread++);
                sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}