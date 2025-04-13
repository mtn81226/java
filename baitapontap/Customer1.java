
public class Customer1 {
private int id;
private String Name;
private char Gender;
public Customer1(int id, String Name, char Gender) {
	this.id = id;
	this.Name = Name;
	this.Gender = Gender;
}
public int getId() {
	return id;
}
public String getName() {
	return Name;
}
public char getGender() {
	return Gender;
}

public String toString() {
	return Name + "("+id+")";
}

}
