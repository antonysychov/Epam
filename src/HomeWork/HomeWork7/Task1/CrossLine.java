package HomeWork.HomeWork7.Task1;

public class CrossLine implements Controllable {
    private Line[] lines = new Line[2];
    boolean visible = false;

    @Override
    public void changeSize(int percent) {
        for (Line l : lines) {
            l.changeSize(percent);
        }
    }

    @Override
    public void hide() {
        visible = false;
    }

    @Override
    public void shift(Direction d, int offset) {

    }

    @Override
    public void show() {
        visible = true;
        System.out.println("Перекрестье :");
        lines[0].show();
        lines[1].show();
    }
}
