
public class MyCircle {
private MyPoint center = new MyPoint(0,0);
private int radius = 1; 
public MyCircle() {
}
public MyCircle(int x, int y, int radius) {
	this.center = new MyPoint(x,y);
	this.radius = radius;
}
public MyCircle(MyPoint center, int radius) {
	this.center = center;
	this.radius = radius;
}
public MyPoint getCenter() {
	return center;
}
public void setCenter(MyPoint center) {
	this.center = center;
}
public int getRadius() {
	return radius;
}
public void setRadius(int radius) {
	this.radius = radius;
}
public void setCenterX(int x) {
	center.setX(x);
}
public int getCenterX() {
	return center.getX();
}
public void setCenterY(int y) {
	center.setY(y);
}
public int getCenterY() {
	return center.getX();
}
public void setCenterXY(int x, int y) {
	center.setXY(x, y);
}
public int [] getCenterXY() {
	return center.getXY();
}

public String toString() {
	return "MyCircle [center=" + center + ", radius=" + radius + "]";
}
public double getArea() {
	return radius*radius*Math.PI;
}
public double getCircumference() {
	return 2*radius*Math.PI;
}
public double distance(MyCircle another) {
	return center.distance(another.getCenter());
}
}
