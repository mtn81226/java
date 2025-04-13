
public class TestMain4 {
public static void main(String[] args) {
	MyPoint p1 = new MyPoint(4,8);
	MyPoint p2 = new MyPoint(5,7);
	System.out.println(p1);
	System.out.println(p2);
	System.out.println("Khoảng cách từ p1 đến p2"+p1.distance(p2));
	System.out.println("Khoảng cách từ p2 đến (9,6):"+p2.distance(9, 6));
	System.out.println("Khoảng cách từ p1 đến gốc tọa độ:"+p1.distance());
}
}
