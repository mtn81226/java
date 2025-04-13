
public class Book3 {
private String isbn;
private String Name;
private Author1 author;
private double Price;
private int Qty = 0;
public Book3(String isbn, String name, Author1 author, double price) {

	this.isbn = isbn;
	this.Name = name;
	this.author = author;
	this.Price = price;
}
public Book3(String isbn, String name, Author1 author, double price, int qty) {
	this.isbn = isbn;
	this.Name = name;
	this.author = author;
	this.Price = price;
	this.Qty = qty;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public int getQty() {
	return Qty;
}
public void setQty(int qty) {
	Qty = qty;
}
public String getIsbn() {
	return isbn;
}
public String getName() {
	return Name;
}
public Author1 getAuthor() {
	return author;
}
public String getAuthorName() {
	return author.getName();
}
public String toString() {
	return "Book3 [isbn=" + isbn + ", Name=" + Name + ", author=" + author + ", Price=" + Price + ", Qty=" + Qty + "]";
}

}
