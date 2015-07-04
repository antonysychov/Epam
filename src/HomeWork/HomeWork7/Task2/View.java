package HomeWork.HomeWork7.Task2;

import HomeWork.HomeWork7.Task2.Shape.Primitives.Ellipsoid;
import HomeWork.HomeWork7.Task2.Shape.Primitives.Line;
import HomeWork.HomeWork7.Task2.Shape.Primitives.Primitive;
import HomeWork.HomeWork7.Task2.Shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class ShapeView extends JPanel {
    Shape s;

    public ShapeView(Shape s) {
        this.s = s;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);

        Dimension size = getSize();
        Insets insets = getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;

        Random r = new Random();

        for (Primitive p : s.getPrimitives()) {
            if (p.getClass() == Line.class) {
                Line l = (Line) p;
                g2d.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
            } else if (p.getClass() == Ellipsoid.class) {
                Ellipsoid e = (Ellipsoid) p;
                g2d.drawRoundRect(e.getxCenter(), e.getyCenter(), e.getBigRadius(), e.getSmallRadius(), 70, 70);
            }
        }
        //g2d.drawLine(110, 100, 120, 130);
        //g2d.drawLine(90, 100, 70, 130);
        //g.drawRoundRect(60, 50, 80, 50, 70, 70);
        //g.drawRoundRect(40, 33, 80 / 2, 50 / 2, 70, 70);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class View extends JFrame {

    private ShapeView sv;

    public View(ShapeView sv) {

        this.sv = sv;
        initUI();
    }

    private void initUI() {

        setTitle(sv.s.getType().toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(sv);
        setSize(200, 200);
        setLocationRelativeTo(null);
    }

    public void print (){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View ps = new View(sv);
                ps.setVisible(true);
            }
        });
    }


}