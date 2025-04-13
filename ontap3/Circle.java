public class Circle {
   private double radius;
   private String color;

   // Constructors
   public Circle() {
      radius = 1.0;
      color = "red";
   }

   public Circle(double radius) {
      this.radius = radius;
      color = "red";
   }

   public Circle(double radius, String color) {
      this.radius = radius;
      this.color = color;
   }

   // Getter for radius
   public double getRadius() {
      return radius;
   }

   // Getter for color
   public String getColor() {
      return color;
   }

   // Method to get area of circle
   public double getArea() {
      return Math.PI * radius * radius;
   }

   @Override
   public String toString() {
      return "Circle[radius=" + radius + ",color=" + color + "]";
   }
}
