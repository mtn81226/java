
public class TestPerson {
	public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        System.out.println(person);

        Student student = new Student("Jane Doe", "456 University Ave", "CS", 2023, 2000);
        System.out.println(student);

        Staff staff = new Staff("Prof. Smith", "789 College Rd", "Engineering", 50000);
        System.out.println(staff);
    }
}
