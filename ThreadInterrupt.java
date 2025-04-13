
public class ThreadInterrupt {
public static void main(String[] args) {
	Thread th = new Thread(()-> {
		while(! Thread.currentThread().isInterrupted()){
			System.out.println("Running...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted!");
				break;
			}
		}
	});
		th.start();
		try { Thread.sleep(3000);
} catch(InterruptedException e) {}
		th.interrupt();
}
}
