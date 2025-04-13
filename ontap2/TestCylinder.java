public class TestCylinder {
   public static void main(String[] args) {
     
      Cylinder cyl1 = new Cylinder();
      System.out.println(cyl1);  
      System.out.println("Volume: " + cyl1.getVolume()); 

   
      Cylinder cyl2 = new Cylinder(2.0, "blue", 5.0);
      System.out.println(cyl2);  
      System.out.println("Volume: " + cyl2.getVolume()); 
   }
}
