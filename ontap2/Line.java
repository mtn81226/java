public class Line {
   private Point1 begin;   
   private Point1 end;     


   public Line(Point1 begin, Point1 end) {
      this.begin = begin;
      this.end = end;
   }

  
   public Line(int beginX, int beginY, int endX, int endY) {
      this.begin = new Point1(beginX, beginY);
      this.end = new Point1(endX, endY);
   }

 
   public String toString() {
      return "Line[begin=" + begin + ",end=" + end + "]";
   }

   public Point1 getBegin() {
      return begin;
   }

   public Point1 getEnd() {
      return end;
   }

   public void setBegin(Point1 begin) {
      this.begin = begin;
   }

   public void setEnd(Point1 end) {
      this.end = end;
   }

   public int getLength() {
      int xDiff = end.getX() - begin.getX();
      int yDiff = end.getY() - begin.getY();
      return (int)Math.sqrt(xDiff * xDiff + yDiff * yDiff);
   }

   public double getGradient() {
      int xDiff = end.getX() - begin.getX();
      int yDiff = end.getY() - begin.getY();
      return Math.atan2(yDiff, xDiff); 
   }
}
