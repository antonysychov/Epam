package HomeWork.HomeWork7.Task2.Builder;

import HomeWork.HomeWork7.Task2.Shape.Shape;

public abstract class Builder {

    Shape shape;

    public abstract void buildShape();

    public Shape getShape() {
        return shape;
    }


}
