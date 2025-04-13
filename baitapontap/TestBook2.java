public class TestBook2 {
public static void main(String[] args) {
	Author[] authors = new Author[2];
	authors[0] = new Author("Linh","Linh@gmail.com",'f');
	authors[1] = new Author("Nguyệt","nguyet45@gmail.com",'f');
	Book2 bok1 = new Book2("Java cơ bản",authors,29.9,19);
	System.out.println(bok1);
	bok1.setPrice(29.99);
    bok1.setQty(28);
    System.out.println("name is: " + bok1.getName());
    System.out.println("price is: " + bok1.getPrice());
    System.out.println("qty is: " + bok1.getQty());

    System.out.println("Authors are: " + bok1.getAuthorNames());

}
}
