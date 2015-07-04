package HomeWork.HomeWork7.Task1;

public class Line implements Controllable {
    private Point[] points = new Point[2];
    boolean visible = false;

    @Override
    public void changeSize(int percent) {
        int x2 = points[1].getC().getX();
        int x1 = points[0].getC().getX();
        int y2 = points[1].getC().getY();
        int y1 = points[0].getC().getY();

        int length = (int) Math.sqrt(
                Math.pow(2, x2 - x1) + Math.pow(2, y2 - y1));

        int newLength = (length * percent) / 100;
        int xMid = (x2 + x1) / 2;
        int yMid = (y2 + y1) / 2;
        int xdif = Math.abs(xMid - x1);
        int ydif = Math.abs(yMid - y1);
        double xCoef = newLength / xdif;
        double yCoef = newLength / ydif;

        int newX1 = (int) ((x1 < x2) ? x1 - xdif * xCoef : x1 + xdif * xCoef);
        int newX2 = (int) ((x1 < x2) ? x2 + xdif * xCoef : x2 - xdif * xCoef);
        int newY1 = (int) ((y1 < y2) ? y1 - ydif * yCoef : y1 + ydif * yCoef);
        int newY2 = (int) ((y1 < y2) ? y2 + ydif * yCoef : y2 - ydif * yCoef);
        points[1].getC().setX(newX2);
        points[0].getC().setX(newX1);
        points[1].getC().setY(newY2);
        points[0].getC().setY(newY1);
    }

    @Override
    public void show() {
        visible = true;
        System.out.println("Линия :");
        points[0].show();
        points[1].show();
    }

    @Override
    public void hide() {
        visible = false;
        System.out.println("Линия спрятана");
    }

    @Override
    public void shift(Direction d, int offset) {
        for (Point p : points) {
            p.shift(d, offset);
        }
    }
}
