
public class TestGeometricObject {
    public static void main(String[] args) {
        GeometricObject obj = new Circle1(5.0);
        System.out.println(obj);
        System.out.println("Area: " + obj.getArea());
        System.out.println("Perimeter: " + obj.getPerimeter());
    }
}