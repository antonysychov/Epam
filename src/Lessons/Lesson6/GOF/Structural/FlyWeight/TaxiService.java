package Lessons.Lesson6.GOF.Structural.FlyWeight;

import java.util.LinkedList;
import java.util.Queue;

public class TaxiService {
    Queue<Car> s = new LinkedList<>();
    Queue<Car> l = new LinkedList<>();

    public TaxiService() {
        Car c1 = new Sedan();
        Car c2 = new Lorry();
        s.add(c1);
        l.add(c2);
    }

    Car getCar(int order) {
        switch (order) {
            case 1: {
                Car sd = s.remove();
                if (sd == null) return null;
                return sd;
            }
            case 2: {
                Car sd = s.remove();
                if (sd == null) return null;
                return sd;
            }
        }
        return null;
    }
}

class Sedan extends Car {
}

class Lorry extends Car {
}

class Car {
}

class Test {
    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        taxiService.getCar(2);
    }
}

//Car - FlyWeight