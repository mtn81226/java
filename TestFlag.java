
public class TestFlag {
public static void main(String[] args) {
	Flag f = new Flag();
	Thread t1 = new Thread(() -> {
		while(f.running) {}
		System.out.println("Thread stopped");
	});
	t1.start();
	try { Thread.sleep(1000);
} catch(InterruptedException e) {}
	f.running = false;
}
}
