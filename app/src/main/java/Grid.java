public class Grid {
    private int width;
    private int height;
    private Cell[][] cells;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = createCells();
    }

    private Cell[][] createCells() {
        Cell[][] cells = new Cell[this.width][this.height];
        for (int rowIndex = 0; rowIndex < this.width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.height; columnIndex++) {
                cells[rowIndex][columnIndex] = new Cell();
            }
        }
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Cell getCell(Coordinates coordinates) {
        return cells[coordinates.getX()][coordinates.getY()];
    }

    public boolean contains(Coordinates coordinates) {
        if (coordinates.getX() < this.width && coordinates.getY() < this.height) {
            return true;
        }
        return false;
    }

    public ShotResult shootAt(Coordinates coordinates) {
        if (!contains(coordinates)) {
            return ShotResult.MISSED;
        }
        return getCell(coordinates).takeAShot();
    }

    public boolean hasBeenShotAt(Coordinates coordinates) {
        return getCell(coordinates).getHasBeenShot();
    }

    public boolean hasShipAt(Coordinates coordinates) {
        return getCell(coordinates).hasShip();
    }

    public void putShip(Ship ship, Coordinates firstCoordinates, Orientation orientation) {
        Position shipPosition = new Position(ship, firstCoordinates, orientation);
        Coordinates[] shipCoordinates = shipPosition.shipCoordinates();
        for (Coordinates coord : shipCoordinates) {
            getCell(coord).setShip(ship);
        }
    }

    public boolean isCompleted() {
        for (int rowIndex = 0; rowIndex < this.width; rowIndex++) {
            for (int columnIndex = 0; columnIndex < this.height; columnIndex++) {
                Cell cellAnalyzed = getCell(new Coordinates(rowIndex, columnIndex));
                if (!cellAnalyzed.getShip().hasBeenSunk()) {
                    return false;
                }
            }
        }
        return true;
    }
}
