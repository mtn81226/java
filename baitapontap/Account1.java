
public class Account1 {
private int id;
private Customer1 customer;
private double balance = 0.0;
public Account1(int id, Customer1 customer, double balance) {
	this.id = id;
	this.customer = customer;
	this.balance = balance;
}
public Account1(int id, Customer1 customer) {
	this.id = id;
	this.customer = customer;
}
public int getId() {
	return id;
}
public Customer1 getCustomer() {
	return customer;
}
public void setBalance(double balance) {
	balance = balance;
}
public double getbalance() {
	return balance;
}
public String toString() {
	return "Account1 [id=" + id + ", customer=" + customer + ", balance=" + balance + "]";
}
public String getCustomerName() {
	return customer.getName();
	}
// nạp tiền
public void deposit(double amount) {
	balance +=amount;
}
// rút tiền
public void withdraw(double amount) {
	if(balance >= amount) {
	balance -= amount;	
	} else {
		System.out.println("amount withdraw exceeds the current blance!");
	}
	
}
}
