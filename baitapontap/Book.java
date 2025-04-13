
public class Book {
private String Name;
private Author author;
private double Price;
private int Qty = 0;
public Book(String Name, Author author, double Price) {
	this.Name = Name;
	this.author = author;
	this.Price = Price;
}
public Book(String Name, Author author, double Price, int Qty) {
	this.Name = Name;
	this.author = author;
	this.Price = Price;
	this.Qty = Qty;
}
public String getName() {
	return Name;
}
public Author getAuthor() {
	return author;
}
public void setPrice(double Price) {
	Price = Price;
}
public double getPrice() {
	return Price;
}
public void setQty(int Qty) {
	Qty = Qty;
}
public int getQty() {
	return Qty;
}

public String toString() {
	return "Book [Name=" + Name + ", author=" + author + ", Price=" + Price + ", Qty=" + Qty + "]";
}

}
