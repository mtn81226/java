public class TestPoint {
   public static void main(String[] args) {
      Point1 p1 = new Point1(10, 20);   // Construct a Point
      System.out.println(p1);         // Output: (10,20)

     
      p1.setXY(100, 10);
      System.out.println(p1);         // Output: (100,10)
   }
}
