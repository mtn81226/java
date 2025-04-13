
public class TestMovablePoint {
	 public static void main(String[] args) {
	        Point p1 = new Point(1.5f, 2.5f);
	        System.out.println(p1);

	        MovablePoint mp1 = new MovablePoint(1.5f, 2.5f, 0.5f, 1.0f);
	        System.out.println(mp1);
	        mp1.move();
	        System.out.println("After move: " + mp1);
	    }
}
