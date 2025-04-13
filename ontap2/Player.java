public class Player {
    private String name;
    private int number;
    private float x, y;

    public Player(String name, int number, float x, float y) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(float xDisp, float yDisp) {
        x += xDisp;
        y += yDisp;
    }

    public void kick(Ball1 ball, float xSpeed, float ySpeed) {
        ball.setXSpeed(xSpeed);
        ball.setYSpeed(ySpeed);
    }

    
    public String toString() {
        return String.format("Player %s at (%.1f, %.1f)", name, x, y);
    }
}
