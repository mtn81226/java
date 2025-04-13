public class LineSub extends Point {
   private Point end;  // Ending point

   // Constructor with individual coordinates
   public LineSub(int beginX, int beginY, int endX, int endY) {
      super(beginX, beginY);   // Call Point's constructor
      this.end = new Point(endX, endY);  // Construct the end point
   }

   // Constructor with Point objects
   public LineSub(Point begin, Point end) {
      super(begin.getX(), begin.getY());  // Call Point's constructor
      this.end = end;
   }

   // Public methods
   @Override
   public String toString() {
      return "LineSub[begin=(" + getX() + "," + getY() + "),end=" + end + "]";
   }

   public Point getEnd() {
      return end;
   }

   public void setEnd(Point end) {
      this.end = end;
   }

   public int getLength() {
      int xDiff = end.getX() - getX();
      int yDiff = end.getY() - getY();
      return (int)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
   }

   public double getGradient() {
      int xDiff = end.getX() - getX();
      int yDiff = end.getY() - getY();
      return Math.atan2(yDiff, xDiff);
   }
}
