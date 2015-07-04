package Lessons.Lesson6.GOF.Creational.Prototype;

public class Prototype {

}

class A implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //
        return this;
    }
}
