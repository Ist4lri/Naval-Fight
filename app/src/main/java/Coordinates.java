public class Coordinates {
    private int x;
    private int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinates testCoordinates = (Coordinates) o;
        return this.x == testCoordinates.x && this.y == testCoordinates.y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public Coordinates addCoordinates(Coordinates c) {
        return new Coordinates(c.getX() + this.x, c.getY() + this.y);
    }
}
