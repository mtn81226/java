
public class Author {
private String Name;
private String Email;
private char Gender;
public Author(String Name, String Email, char Gender) {
	this.Name = Name;
	this.Email = Email;
	this.Gender = Gender;
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
public char getGender() {
	return Gender;
}

public String toString() {
	return "Author [Name=" + Name + ", Email=" + Email + ", Gender=" + Gender + "]";
}

}
