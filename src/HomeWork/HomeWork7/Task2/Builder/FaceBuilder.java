package HomeWork.HomeWork7.Task2.Builder;

import HomeWork.HomeWork7.Task2.Shape.Primitives.Ellipsoid;
import HomeWork.HomeWork7.Task2.Shape.Shape;
import HomeWork.HomeWork7.Task2.Shape.ShapeType;

public class FaceBuilder extends Builder {
    @Override
    public void buildShape() {
        shape = new Shape();
        shape.setType(ShapeType.FACE);
        shape.addPrimitive(new Ellipsoid(60, 50, 80, 50));
        shape.addPrimitive(new Ellipsoid(40, 33, 80 / 2, 50));
        //shape.addPrimitive(new Line());
        //shape.addPrimitive(new Line());
    }
}
