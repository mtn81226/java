
public class Main1 {
	public static void main(String[] args) {
        
        MyComplex c1 = new MyComplex(3, 4);
        MyComplex c2 = new MyComplex(1, -2);

       
        System.out.println("Số phức c1: " + c1);
        System.out.println("Số phức c2: " + c2);


        MyComplex c3 = c1.addNew(c2);
        System.out.println("Cộng c1 và c2: " + c3);

       
        MyComplex c4 = c1.subtractNew(c2);
        System.out.println("Trừ c1 và c2: " + c4);

      
        MyComplex c5 = c1.multiply(c2);
        System.out.println("Nhân c1 và c2: " + c5);

        
        System.out.println("Độ lớn của c1: " + c1.magnitude());
        System.out.println("Góc pha của c1 (radians): " + c1.argument());
    }
}
