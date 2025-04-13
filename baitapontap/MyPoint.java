
public class MyPoint {
private int x = 0;
private int y = 0;
public MyPoint() {
}
public MyPoint(int x, int y) {
	this.x = x;
	this.y = y;
}
public void setX(int x) {
	x = x;
}
public int getX() {
	return x;
}
public void setY(int y) {
	y = y;
}
public int getY() {
	return y;
}
public void setXY(int x, int y) {
	x = x;
	y = y;
}
public int[] getXY(){
	return new int[] {x,y};
}

public String toString() {
	return "MyPoint (" + x + "," + y + ")";
}
public double distance() {
	return Math.sqrt(x*x+y*y);
}
public double distance(int x, int y) {
	int dx = this.x -x;
	int dy = this.y - y;
	return Math.sqrt(dx*dx+dy*dy);
}
public double distance(MyPoint another) {
	int dx = this.x - another.x;
	int dy = this.y - another.y;
	return Math.sqrt(dx*dx+dy*dy);
}

}
