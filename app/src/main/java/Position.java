public class Position {
    private int shipLenght;
    private Coordinates firstCellCoordinates;
    private Orientation shipOrientation;

    Position(Ship ship, Coordinates firstCellCoordinates, Orientation orientation) {
        this.shipLenght = ship.getShippLifePoints();
        this.firstCellCoordinates = firstCellCoordinates;
        this.shipOrientation = orientation;
    }

    Coordinates[] shipCoordinates() {
        Coordinates[] shipCoordinates = new Coordinates[this.shipLenght + 1];
        for (int i = 0; i <= this.shipLenght; i++) {
            if (this.shipOrientation == Orientation.HORIZONTAL) {
                shipCoordinates[i] = new Coordinates(firstCellCoordinates.getX() + i, firstCellCoordinates.getY());
            } else {
                shipCoordinates[i] = new Coordinates(firstCellCoordinates.getX(), firstCellCoordinates.getY() + i);
            }
        }
        return shipCoordinates;
    }
}
