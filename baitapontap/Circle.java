public class Circle {
private double radius ;
private String color;
public Circle() {
	this.radius = 1.0;
	this.color = "red";
}
public Circle(double radius) {
	this.radius = radius;
	this.color = "red";
}

public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public double getRadius() {
	return radius; 
}
public double getArea() {
	return radius*radius*Math.PI;
}
}
