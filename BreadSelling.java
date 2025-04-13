public class BreadSelling {
    public static void main(String[] args) {
        BreadBuffer buffer = new BreadBuffer(5);

        BreadProducer producer = new BreadProducer(buffer);
        BreadConsumer consumer = new BreadConsumer(buffer);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.stopProducing();
        consumer.stopConsuming();
    }
}