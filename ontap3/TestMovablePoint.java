public class TestMovablePoint {
    public static void main(String[] args) {
      
        Point point = new Point(1.0f, 2.0f);
        System.out.println("Point: " + point);

       
        MovablePoint movablePoint = new MovablePoint(1.0f, 2.0f, 3.0f, 4.0f);
        System.out.println("Before move: " + movablePoint);
        movablePoint.move();
        System.out.println("After move: " + movablePoint);
    }
}
