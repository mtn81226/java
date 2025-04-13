public class SoccerGame {
    public static void main(String[] args) {
        Ball1 soccerBall = new Ball1(0, 0, 0, 0);

        Team team1 = new Team("Team A");
        team1.addPlayer(new Player("Alice", 1, 10, 20));
        team1.addPlayer(new Player("Bob", 2, 15, 25));

        Team team2 = new Team("Team B");
        team2.addPlayer(new Player("Charlie", 3, 30, 40));
        team2.addPlayer(new Player("David", 4, 35, 45));

        System.out.println(team1);
        for (Player p : team1.getPlayers()) {
            System.out.println(p);
        }

        System.out.println(team2);
        for (Player p : team2.getPlayers()) {
            System.out.println(p);
        }

        team1.getPlayers().get(0).kick(soccerBall, 2, 3);
        soccerBall.move();
        System.out.println(soccerBall);
    }
}
