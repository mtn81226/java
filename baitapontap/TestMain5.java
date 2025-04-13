
public class TestMain5 {
	public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(3, 4);

        MyLine line = new MyLine(p1, p2);
        System.out.println(line); 

        System.out.println("Độ dài của đường thẳng: " + line.getLength());
        System.out.println("Độ dốc của đường thẳng (radians): " + line.getGradient());
    }
}

