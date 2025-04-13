
public class Customer {
private int id;
private String Name;
private int Discount;
public Customer(int id, String name, int discount) {
	this.id = id;
	this.Name = name;
    this.Discount = discount;
}
public int getDiscount() {
	return Discount;
}
public void setDiscount(int discount) {
	Discount = discount;
}
public int getId() {
	return id;
}
public String getName() {
	return Name;
}

public String toString() {
	return "Customer [id=" + id + ", Name=" + Name + ", Discount=" + Discount + "]";
}

}
