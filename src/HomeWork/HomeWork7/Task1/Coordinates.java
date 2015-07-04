package HomeWork.HomeWork7.Task1;

public class Coordinates {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void shift(Direction d, int offset) {
        switch (d) {
            case UP:
                y += offset;
                break;
            case DOWN:
                y -= offset;
                break;
            case RIGHT:
                x += offset;
                break;
            case LEFT:
                x -= offset;
                break;
        }
    }
}
