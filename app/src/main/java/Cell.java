public class Cell {
    private Ship ship;
    private boolean hasBeenShot;

    Cell(Ship ship, boolean hasBeenShot) {
        this.ship = ship;
        this.hasBeenShot = hasBeenShot;
    }

    Ship getShip() {
        return this.ship;
    }

    void setShip(Ship ship) {
        this.ship = ship;
    }

    boolean hasShip() {
        return this.ship != null;
    }

    ShotResult takeAShot() {
        return ShotResult.SHOT;
    }

    boolean getHasBeenShot() {
        return this.hasBeenShot;
    }
}
