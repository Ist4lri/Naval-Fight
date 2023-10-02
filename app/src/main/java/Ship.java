public class Ship {
    private int shippLifePoints;
    private String name;

    Ship(int shippLifePoints, String name) {
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
        return getShippLifePoints() == 0;
    }

    public void takeAHit() {
        if (this.shippLifePoints != 0) {
            this.shippLifePoints--;
        }
    }

    public String toString() {
        return ("The " + this.name + " has " + this.shippLifePoints + " PV.");
    }
}
