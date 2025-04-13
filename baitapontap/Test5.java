public class Test5 {
	 public static void main(String[] args) {
	      InvoiceItem inv1 = new InvoiceItem("24ab", "f", 2000, 4.25);
	      System.out.println(inv1); 
	      inv1.setQty(1000);
	      inv1.setUnitPrice(2.5);
	      System.out.println(inv1);  
	      System.out.println("Id is: " + inv1.getID());
	      System.out.println("Desc is: " + inv1.getDesc());
	      System.out.println("Qty is: " + inv1.getQty());
	      System.out.println("UnitPrice is: " + inv1.getUnitPrice());
	      System.out.println("The total is: " + inv1.getTotal());
	   }
}
