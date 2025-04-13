
public class Main3 {
	public static void main(String[] args) {
        
        MyTime time = new MyTime(23, 59, 59);

       
        System.out.println("Thời gian hiện tại: " + time);

        
        time.nextSecond();
        System.out.println("Sau khi tăng 1 giây: " + time);

       
        time.previousSecond();
        time.previousSecond();
        System.out.println("Sau khi giảm 2 giây: " + time);

       
        time.nextMinute();
        System.out.println("Sau khi tăng 1 phút: " + time);

       
        time.previousHour();
        System.out.println("Sau khi giảm 1 giờ: " + time);
    }
}
