package HomeWork.HomeWork7.Task2.Shape;

import HomeWork.HomeWork7.Task2.Shape.Primitives.Primitive;

import java.util.LinkedList;
import java.util.List;

public class Shape {
    private ShapeType type;
    private List<Primitive> primitives = new LinkedList<>();

    public ShapeType getType() {
        return type;
    }

    public void setType(ShapeType name) {
        this.type = name;
    }

    public void addPrimitive(Primitive p) {
        primitives.add(p);
    }

    public void deletePrimitive(Primitive p) {
        primitives.remove(p);
    }

    public List<Primitive> getPrimitives() {
        return primitives;
    }
}
