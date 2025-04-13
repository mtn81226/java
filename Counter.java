public class Counter {
int count = 0;
// đồng bộ phương thức
synchronized void increment() {
	count++;
}
}
