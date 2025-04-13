public class TestLine {
   public static void main(String[] args) {
      Line l1 = new Line(0, 0, 3, 4); 
      System.out.println(l1);         
      System.out.println("Length: " + l1.getLength()); 
      System.out.println("Gradient: " + l1.getGradient()); 

      Point1 p1 = new Point1(1, 1);
      Point1 p2 = new Point1(4, 5);
      Line l2 = new Line(p1, p2);
      System.out.println(l2);         
      System.out.println("Length: " + l2.getLength()); 
   }
}
