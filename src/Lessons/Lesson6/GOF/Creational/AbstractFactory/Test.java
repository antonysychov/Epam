package Lessons.Lesson6.GOF.Creational.AbstractFactory;

public class Test {
    public static void main(String[] args) {
        ConcreteShapeFactory concreteShapeFactory = ShapeFactory.getFactory(1);
        Shape s = concreteShapeFactory.getShape();
        s.print();
    }
}
