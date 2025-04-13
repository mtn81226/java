
public class TestMain3 {
public static void main(String[] args) {
	
	       
	        Customer1 cus = new Customer1 (1, "John", 'm');
	         
	        Account1 ac = new Account1 (2, cus, 500.0);
	        
	        
	        System.out.println(ac);  
	        System.out.println("Account ID: " + ac.getId());
	        System.out.println("Customer: " + ac.getCustomer());
	        System.out.println("Customer's name: " + ac.getCustomerName());
	        System.out.println("Balance: $" + ac.getbalance());
	        
	        
	        ac.deposit(200.0);
	        System.out.println("After deposit, balance: $" + ac.getbalance());

	        ac.withdraw(100.0);
	        System.out.println("After withdrawal, balance: $" + ac.getbalance());

	       ac.withdraw(700.0);  
}
}
