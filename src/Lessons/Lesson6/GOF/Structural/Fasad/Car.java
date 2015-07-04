package Lessons.Lesson6.GOF.Structural.Fasad;

public class Car {
    Engine e;
    Pedal[] pedals = new Pedal[3];
    public void move(){
        e.startEngine();
        for (int i = 0; i < 3; i++) {
            pedals[i].push();
        }
    }
}


class Pedal {
    void push(){};
}
class Engine {
    void startEngine(){};
}

class Test{
    public static void main(String[] args) {
        Car car = new Car();
        car.move();
    }
}