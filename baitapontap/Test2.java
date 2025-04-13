
public class Test2 {
public static void main(String[] args) {
	Circle1 ci1 = new Circle1(3.5);
	System.out.println(ci1);
	Circle1 ci2 = new Circle1();
	System.out.println(ci2);
	ci1.setRadius(3.4);
	System.out.println(ci1);
	System.out.println("Radius = "+ci1.getRadius());
	System.out.printf("Area =  %.2f%n" ,ci1.getArea());
	System.out.printf("Circumference = %.2f%n ",ci2.getCircumference());
}
}
