import java.util.Arrays;

public class Book2 {
private String Name;
private Author[] authors;
private double Price;
private int Qty = 0;
public Book2(String name, Author[] authors, double price) {
	this.Name = name;
	this.authors = authors;
	this.Price = price;
}
public Book2(String name, Author[] authors, double price, int qty) {
	this.Name = name;
	this.authors = authors;
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
public String getName() {
	return Name;
}
public Author[] getAuthors() {
	return authors;
}

public String toString() {
	return "Book2 [Name=" + Name + ", authors=" + Arrays.toString(authors) + ", Price=" + Price + ", Qty=" + Qty + "]";
}
public String getAuthorNames() {
	StringBuilder authorNames = new StringBuilder();
    for (Author author : authors) {
        authorNames.append(author.getName()).append(", ");
    }
    return authorNames.substring(0, authorNames.length() - 2); 	
}
}
