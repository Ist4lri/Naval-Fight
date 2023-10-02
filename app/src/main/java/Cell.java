public class Cell {
    private Ship ship;
    private boolean hasBeenShot;

    public Cell() {
        this.ship = null;
        this.hasBeenShot = false;
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
        if (getHasBeenShot() || !hasShip()) {
            this.hasBeenShot = true;
            return ShotResult.MISSED;
        }
        this.hasBeenShot = true;
        Ship attackedShip = this.getShip();
        if (attackedShip.hasBeenSunk()) {
            return ShotResult.MISSED;
        }
        attackedShip.takeAHit();
        if (attackedShip.hasBeenSunk()) {
            return ShotResult.SUNK;
        }
        return ShotResult.SHOT;
    }

    public boolean getHasBeenShot() {
        return this.hasBeenShot;
    }
}
