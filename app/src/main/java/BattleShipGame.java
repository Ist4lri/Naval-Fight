import java.util.Scanner;

public class BattleShipGame {
    private int turnCount;
    private GridPrinter gridPrinter;
    private Grid grid;
    private Scanner scanner;

    public BattleShipGame(Grid grid) {
        this.turnCount = 0;
        this.gridPrinter = new GridPrinter(grid);
        this.grid = grid;
        this.scanner = new Scanner(System.in);
    }

    public void playGame() {
        this.gridPrinter.printGrid();
        do {
            playTurn();
            this.gridPrinter.printGrid();
        } while (!this.grid.isCompleted());
        printWinningMessage();
    }

    public void playTurn() {
        printTurnNumberMessage();
        printShotResult();
    }

    public void printTurnNumberMessage() {
        System.out.println("Turn number :" + this.turnCount);
    }

    public void printShotResult() {
        Coordinates coordinateToShot = collectCoordinates();
        ShotResult result = grid.shootAt(coordinateToShot);
        switch (result) {
            case MISSED:
                System.out.println("You missed");
                break;
            case SHOT:
                System.out.println("You've got a shot ! Well played");
                break;
            case SUNK:
                System.out.println("You sunk a ship ! BAZIMBA !");
                break;
        }

    }

    public Coordinates collectCoordinates() {
        String input = scanner.next("\\d\\d");
        String[] splittedFields = input.split("");
        return new Coordinates(Integer.parseInt(splittedFields[0]), Integer.parseInt(splittedFields[1]));
    }

    public void printWinningMessage() {
        System.out.println("You have won in " + this.turnCount + " turns .");
    }
}