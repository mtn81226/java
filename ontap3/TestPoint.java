import java.util.Arrays;

public class TestPoint {
    public static void main(String[] args) {
      
        Point2D point2D = new Point2D(3.0f, 4.0f);
        System.out.println("Point2D: " + point2D);
        System.out.println("XY: " + Arrays.toString(point2D.getXY()));

        Point3D point3D = new Point3D(1.0f, 2.0f, 3.0f);
        System.out.println("Point3D: " + point3D);
        System.out.println("XYZ: " + Arrays.toString(point3D.getXYZ()));
    }
}
