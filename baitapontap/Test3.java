
public class Test3 {
public static void main(String[] args) {
	Rectangle r1 = new Rectangle(3.4f,4f);
	System.out.println(r1);
	Rectangle r2 = new Rectangle();
	System.out.println(r2);
	r1.setLength(5f);
	r1.setWidth(4.5f);
	System.out.println(r1);
	System.out.println("Width = " +r1.getWidth());
	System.out.println("Length = " +r1.getLength());
	System.out.printf("Area = %.2f%n " ,r1.getArea());
	System.out.printf("Perimeter = %.2f%n" ,r1.getPerimeter());
}
}
