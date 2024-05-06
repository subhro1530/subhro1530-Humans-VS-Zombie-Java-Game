package human_vs_zombie;

public class Player {
    private int n;       // Number of players (humans or zombies)
    private double killRate; // Kill rate for this group
    private String name;     // "Human" or "Zombie"

    public Player(int n, double killRate, String name) {
        this.n = n;
        this.killRate = killRate;
        this.name = name;
    }

    public int getN() {
        return n;
    }

    public double getKillRate() {
        return killRate;
    }

    public void setKillRate(double killRate) {
        this.killRate = killRate;
    }

    public void iterate(double dt, double kills) {
        n -= kills * dt;
    }

    public boolean isAlive() {
        return n > 0;
    }

    public String getName() {
        return name;
    }
}
