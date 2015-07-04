package Lessons.Lesson6.GOF.Creational.Builder;

public class Manager {
    Builder builder;

    public Manager(Builder builder) {
        this.builder = builder;
    }

    public void create() {

        builder.createFundamental();
        builder.createWalls();
        builder.createRoof();


    }
}


abstract class Builder {
    public House h;

    abstract void createFundamental();

    abstract void createWalls();

    abstract void createRoof();

    public House getHouse() {
        return h;
    }
}

class CottageBuilder extends Builder {

    @Override
    void createFundamental() {
        System.out.println("Fund");

    }

    @Override
    void createWalls() {
        System.out.println("Walls");
    }

    @Override
    void createRoof() {
        System.out.println("Roof");
    }
}

abstract class House {
    abstract void show();
}

class Cottage extends House {
    @Override
    void show() {
        System.out.println();
    }
}

class Test {
    public static void main(String[] args) {
        Builder b = new CottageBuilder();
        Manager m = new Manager(b);
        m.create();
        House h = b.getHouse();
        h.show();
    }
}