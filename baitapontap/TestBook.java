
public class TestBook {
public static void main(String[] args) {
	Author au = new Author("Linh Nguyệt","nguyet14@gmail.com",'f');
	System.out.println(au);
	Book b1 = new Book("Tiếng anh A1-A2",au,2000,100);
	System.out.println(b1);
	b1.setPrice(150000);
	b1.setQty(99);
	System.out.println("Name is:"+b1.getName());
	System.out.println("Price is:"+b1.getPrice());
	System.out.println("Qty is:"+b1.getQty());
	System.out.println("Author's Name is:"+b1.getAuthor().getName());
	System.out.println("Author is:"+b1.getAuthor());
	System.out.println("Author's Email is:"+b1.getAuthor().getEmail());
}
}
