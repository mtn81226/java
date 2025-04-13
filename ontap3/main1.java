
public class main1 {
	    public static void main(String[] args) {
	      
	        Person person = new Person("Alice", "123 Main St");
	        System.out.println(person.toString());
	        
	       
	        Student student = new Student("Bob", "456 Oak St", "Computer Science", 2023, 15000.0);
	        System.out.println(student.toString());
	        
	        
	        Staff staff = new Staff("Charlie", "789 Pine St", "XYZ School", 50000.0);
	        System.out.println(staff.toString());
	    }
}
