public class MyLine {
private MyPoint begin;
private MyPoint end;
public MyLine(int x1,int y1, int x2, int y2) {
	this.begin = new MyPoint(x1,y1);
	this.end = new MyPoint(x2,y2);
}
public MyLine(MyPoint begin, MyPoint end) {
	this.begin = begin;
	this.end = end;
}
public MyPoint getBegin() {
	return begin;
}
public void setBegin(MyPoint begin) {
	this.begin = begin;
}
public MyPoint getEnd() {
	return end;
}
public void setEnd(MyPoint end) {
	this.end = end;
}
public void setBeginX(int x) {
	begin.setX(x);
}
public int getBeginX() {
	return begin.getX();
}
public void setBeginY(int y) {
	begin.setY(y);
}
public int getBeginY() {
	return begin.getY();
}
public void setEndX(int x) {
	end.setX(x);
}
public int getEndX() {
	return end.getX();
}
public void setEndY(int y) {
	end.setY(y);
}
public int getEndY() {
	return end.getY();
}
public void setBeginXY(int x, int y) {
	begin.setXY(x, y);
}
public int[] getBeginXY() {
	return begin.getXY();
}
public void setEndXY(int x, int y) {
	end.setXY(x, y);
}
public int[] getEndXY() {
	return end.getXY();
}
// độ dài đường thẳng/ khoảng cách giữa begin vs end
public double getLength() {
	return begin.distance(end);
}
// góc tạo bởi đường thẳng với trục hoành
public double getGradient() {
	int xDiff = end.getX() - begin.getX();
    int yDiff = end.getY() - begin.getY();
    return Math.atan2(yDiff, xDiff);// atan : trả về giá trị radians
}
public String toString() {
    return "MyLine[begin=" + begin + ",end=" + end + "]";
}
}
