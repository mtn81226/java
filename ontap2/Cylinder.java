public class Cylinder {
   private Circle base;  
   private double height;

   
   public Cylinder() {
      base = new Circle();  
      height = 1.0;
   }

  
   public Cylinder(double radius, String color, double height) {
      base = new Circle(radius, color); 
      this.height = height;
   }

   
   public double getVolume() {
      return base.getArea() * height;
   }


   public String toString() {
      return "Cylinder[base=" + base + ",height=" + height + "]";
   }
}
