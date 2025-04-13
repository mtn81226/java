
public class TestResource {
public static void main(String[] args) {
	Resource re1 = new Resource();
	Resource re2 = new Resource();
	Thread th1 = new Thread(() -> re1.methodA(re2));
	Thread th2 = new Thread(() -> re2.methodA(re1));
	th1.start();
	th2.start();
}
}
