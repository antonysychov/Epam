package HomeWork.HomeWork7.Task1;

public class Point implements Controllable {

    private Coordinates c;
    boolean visible = false;

    public Coordinates getC() {
        return c;
    }

    public void setC(Coordinates c) {
        this.c = c;
    }

    @Override
    public void changeSize(int percent) {
    }

    @Override
    public void show() {
        visible = true;
        System.out.println("Точка, координаты: x - " + c.getX() + ", y - " + c.getY());
    }

    @Override
    public void hide() {
        visible = false;
        System.out.println("Точка спрятана");
    }

    @Override
    public void shift(Direction d, int offset) {
        c.shift(d, offset);
    }
}
