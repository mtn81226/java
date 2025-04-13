
public class Author1 {
private String Name;
private String Email;
public Author1(String name, String email) {
	this.Name = name;
	this.Email = email;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getName() {
	return Name;
}

public String toString() {
	return "Author1 [Name=" + Name + ", Email=" + Email + "]";
}

}
