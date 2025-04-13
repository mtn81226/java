public class TestBallPlayer {
    public static void main(String[] args) {
        Ball1 ball1 = new Ball1(0, 0, 0, 0);
        Player player1 = new Player("John", 10, 5, 5);

        System.out.println(player1);
        System.out.println(ball1);

        player1.kick(ball1, 1.5f, 2.0f);
        ball1.move();
        System.out.println(ball1);

        player1.move(2, 3);
        System.out.println(player1);
    }
}
