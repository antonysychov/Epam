package HomeWork.HomeWork7.Task2.Builder;

import HomeWork.HomeWork7.Task2.Shape.Primitives.Ellipsoid;
import HomeWork.HomeWork7.Task2.Shape.Primitives.Line;
import HomeWork.HomeWork7.Task2.Shape.Shape;
import HomeWork.HomeWork7.Task2.Shape.ShapeType;

public class ShipBuilder extends Builder {
    @Override
    public void buildShape() {
        shape = new Shape();
        shape.setType(ShapeType.SHIP);
        shape.addPrimitive(new Ellipsoid(60, 50, 80, 50));
        shape.addPrimitive(new Ellipsoid(40, 33, 80 / 2, 50));
        shape.addPrimitive(new Line(110, 100, 120, 130));
        shape.addPrimitive(new Line(90, 100, 70, 130));
    }
}
