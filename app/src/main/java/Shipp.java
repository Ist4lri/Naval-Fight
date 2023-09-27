public class Shipp {
    private int shippLifePoints;
    private String name;

    Shipp(int shippLifePoints, String name) {
        this.shippLifePoints = shippLifePoints;
        this.name = name;
    }

    public int getShippLifePoints() {
        return this.shippLifePoints;
    }

    public String getShippName() {
        return this.name;
    }

    public boolean hasBeenSunk() {
        return getShippLifePoints() <= 0;
    }

    public void takeAHit() {
        this.shippLifePoints--;
    }
}
