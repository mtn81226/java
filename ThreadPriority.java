
public class ThreadPriority {
public static void main(String[] args) {
	Thread highPriority = new Thread(() -> {
		while(true) {
			System.out.println("High priority Running");
		}
	}); 
	Thread lowPriority = new Thread(() -> {
		while(true) {
			System.out.println("Low priority Running");
		}
	});
	highPriority.setPriority(Thread.MAX_PRIORITY);
	lowPriority.setPriority(Thread.MIN_PRIORITY);
	highPriority.start();
	lowPriority.start();
}
}
