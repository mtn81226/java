
public class TestMain6 {
public static void main(String[] args) {
	MyCircle c1 = new MyCircle(new MyPoint(3,4),5);
	MyCircle c2 = new MyCircle(new MyPoint(6,8),10);
	System.out.println(c1);
	System.out.println(c2);
	
	 System.out.println("Chu vi hình tròn 1: " + c1.getCircumference());
     System.out.println("Diện tích hình tròn 1: " + c1.getArea());
     
     
     System.out.println("Khoảng cách giữa hai hình tròn: " + c1.distance(c2));
}
}
