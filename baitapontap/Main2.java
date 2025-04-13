
public class Main2 {
	   public static void main(String[] args) {
	       
	        MyPolynomial p1 = new MyPolynomial(3.5, 1.25, 2.4); 
	        MyPolynomial p2 = new MyPolynomial(1.4, 1.8);  

	       
	        System.out.println("P1: " + p1);
	        System.out.println("P2: " + p2);

	      
	        MyPolynomial sum = p1.add(p2);
	        System.out.println("P1 + P2: " + sum);

	        
	        MyPolynomial product = p1.multiply(p2);
	        System.out.println("P1 * P2: " + product);

	       
	        double valueAt2 = p1.evaluate(2);
	        System.out.println("P1(2): " + valueAt2);
	    }
	}

