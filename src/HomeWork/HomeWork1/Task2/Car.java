package HomeWork.HomeWork1.Task2;

import java.util.LinkedList;
import java.util.List;

public class Car {
    Engine engine;
    List<Wheel> wheels = new LinkedList<Wheel>();

    public Car(Engine engine, List<Wheel> wheels) {
        this.engine = engine;
        this.wheels = wheels;
    }

    public void drive() {
    }

    ;

    public void addFuel() {
    }

    ;

    public void replaceWheel(Wheel newWheel) {
    }

    ;

    public void printModel() {
        System.out.println("Car model");
    }
}
