public class Test7 {
public static void main(String[] args) {
	Date d1 = new Date(1, 12, 2004);
    System.out.println(d1);  
    d1.setMonth(12);
    d1.setDay(8);
    d1.setYear(2029);
    System.out.println(d1); 
    System.out.println("Month: " + d1.getMonth());
    System.out.println("Day: " + d1.getDay());
    System.out.println("Year: " + d1.getYear());
    d1.setDate(3, 4, 2016);
    System.out.println(d1); 
}
}
