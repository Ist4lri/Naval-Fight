public class GridPrinter {
    private char HIT_CHARACTER;
    private char MISS_CHARACTER;
    private char BLANK_CHARACTER;
    private Grid grid;

    public GridPrinter(Grid grid) {
        this.HIT_CHARACTER = 'H';
        this.MISS_CHARACTER = 'M';
        this.BLANK_CHARACTER = ' ';
        this.grid = grid;
    }

    public void printGrid() {
        printLine();
        printCoordinatesRow();
        for (int index = 0; index < this.grid.getHeight(); index++) {
            printLine();
            printRow(index);
        }
        printLine();
    }

    private String stringASquare(char oneChar) {
        return " " + oneChar + " |";
    }

    private String stringACell(Coordinates coordinates) {
        if (this.grid.hasBeenShotAt(coordinates) && !this.grid.hasShipAt(coordinates)) {
            return stringASquare(MISS_CHARACTER);
        }
        if (this.grid.hasShipAt(coordinates) && this.grid.hasBeenShotAt(coordinates)) {
            return stringASquare(HIT_CHARACTER);
        } else {
            return stringASquare(BLANK_CHARACTER);
        }
    }

    private void printRow(int row) {
        String lineToDisplay = "| " + row + " |";
        for (int index = 0; index < grid.getWidth(); index++) {
            lineToDisplay += stringACell(new Coordinates(row, index));
        }
        System.out.println(lineToDisplay);
    }

    private void printCoordinatesRow() {
        String lineToDisplay = "|   |";
        for (int index = 0; index < grid.getWidth(); index++) {
            lineToDisplay += " " + index + " |";
        }
        System.out.println(lineToDisplay);
    }

    private void printLine() {
        String lineToDisplay = "+---";
        for (int index = 0; index < this.grid.getWidth(); index++) {
            lineToDisplay += "+---";
        }
        System.out.println(lineToDisplay + "+");
    }

}
