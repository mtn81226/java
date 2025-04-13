public class Account {
private String Id;
private String Name;
private int Balance = 0;
public Account(String id, String name) {
	this.Id = id;
	this.Name = name;
}
public Account (String Id, String Name, int Balance) {
	this.Id = Id;
	this.Name = Name;
	this.Balance = Balance;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getBalance() {
	return Balance;
}
public void setBalance(int balance) {
	Balance = balance;
}
public int credit(int amount) {
	Balance+=amount;
	return Balance;
}
public int debit(int amount) {
	if(amount <= Balance) {
		Balance-=amount;
	} else {
		System.out.println("Amount exceeded balance");
	}
	return Balance;
}
public int transferTo(Account antherAccount, int amount) {
	if(amount <= Balance) {
		Balance-=amount;
		antherAccount.credit(amount);
	} else {
		System.out.println("Amount exceeded balance");
	}
	return Balance;
}

public String toString() {
	return "Account [Id=" + Id + ", Name=" + Name + ", Balance=" + Balance + "]";
}

}
