package HomeWork.HomeWork7.Task2;

import HomeWork.HomeWork7.Task2.Builder.*;
import HomeWork.HomeWork7.Task2.Shape.Shape;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Shape> shapes = new LinkedList<>();
        Manager m = new Manager(new DuckBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new FaceBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new HouseBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new PlaneBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new RocketBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new TrainBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new VanBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new WeightlifterBuilder());
        shapes.add(m.construct());
        m.changeBuilder(new ShipBuilder());
        shapes.add(m.construct());

        for (Shape s : shapes) {
            System.out.println(s.getType());
        }

        ShapeView sv = new ShapeView(shapes.getFirst());
        View v = new View(sv);
        v.print();
    }
}
