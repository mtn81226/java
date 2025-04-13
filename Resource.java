
public class Resource {
void methodA(Resource other) {
	Resource first = this.hashCode() < other.hashCode() ? other:this;
Resource second = this.hashCode() < other.hashCode() ? other:this;
synchronized (first) {
	System.out.println(Thread.currentThread().getName() + " locked first resource");
	try {
		Thread.sleep(50);
	} catch(InterruptedException e) {}
	synchronized (second) {
		System.out.println(Thread.currentThread().getName() + " locked second resource");
	}
}
			
}
}
