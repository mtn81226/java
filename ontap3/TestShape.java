public class TestShape {
   public static void main(String[] args) {
    
      Shape shape1 = new Shape();
      System.out.println(shape1);  

      Shape shape2 = new Shape("blue", false);
      System.out.println(shape2);  

  
      Circle1 circle1 = new Circle1();
      System.out.println(circle1);  
      System.out.println("Area: " + circle1.getArea());  
      System.out.println("Perimeter: " + circle1.getPerimeter());  

      Circle1 circle2 = new Circle1(2.5, "red", true);
      System.out.println(circle2);  
      System.out.println("Area: " + circle2.getArea()); 
      System.out.println("Perimeter: " + circle2.getPerimeter());  

     
      Rectangle rectangle1 = new Rectangle();
      System.out.println(rectangle1);  
      System.out.println("Area: " + rectangle1.getArea()); 
      System.out.println("Perimeter: " + rectangle1.getPerimeter());  

      Rectangle rectangle2 = new Rectangle(4.0, 2.0, "yellow", false);
      System.out.println(rectangle2);  
      System.out.println("Area: " + rectangle2.getArea());  
      System.out.println("Perimeter: " + rectangle2.getPerimeter());  

 
      Square square1 = new Square();
      System.out.println(square1);  

      Square square2 = new Square(5.0, "purple", true);
      System.out.println(square2);  
      System.out.println("Area: " + square2.getArea());  
      System.out.println("Perimeter: " + square2.getPerimeter());  
   }
}
