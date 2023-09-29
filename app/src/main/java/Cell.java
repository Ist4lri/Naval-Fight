public class Cell {
    private Ship ship;
    private boolean hasBeenShot;

    Cell(Ship ship, boolean hasBeenShot) {
        this.ship = ship;
        this.hasBeenShot = hasBeenShot;
    }

    public Ship getShip() {
        return this.ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean hasShip() {
        return this.ship != null;
    }

    public ShotResult takeAShot() {
        return ShotResult.SHOT;
    }

    public boolean getHasBeenShot() {
        return this.hasBeenShot;
    }
}
