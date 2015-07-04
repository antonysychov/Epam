package Lessons.Lesson6.GOF.Creational.AbstractFactory;

public class ShapeFactory {
    static ConcreteShapeFactory getFactory(int id){
        switch (id) {
            case 1: return new TriangleShapeFactory();
            case 2: return new RectangleShapeFactory();
            default : return null;
        }
    }
}

abstract class ConcreteShapeFactory{
    abstract Shape getShape();
}

class TriangleShapeFactory extends ConcreteShapeFactory{
    Triangle getShape(){
        return new Triangle();
    }
}

class RectangleShapeFactory extends ConcreteShapeFactory{
    Rectangle getShape(){
        return new Rectangle();
    }
}

abstract class Shape {
    public abstract void print();
}

class Triangle extends Shape{
    @Override
    public void print() {
        System.out.println("Triangle");
    }
}

class Rectangle extends Shape{
    @Override
    public void print() {
        System.out.println("Rectangle");
    }
}