
public class Circle1 {
private double radius;
public Circle1() {
	this.radius = 1.0;
}
public Circle1(double radius) {
	this.radius = radius;
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public double getArea() {
	return radius*radius*Math.PI;
}
public double getCircumference() {
	return 2*Math.PI*radius;
}
public String toString() {
	return "Circle1 [radius=" + radius + "]";
}

}
