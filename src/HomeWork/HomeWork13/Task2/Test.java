package HomeWork.HomeWork13.Task2;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Parking p = new Parking(4);
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Car c = new Car(i);
            cars.add(c);
            c.enterParking(p, 5);
        }

        Thread.sleep(2000);

        p.getParkedCars().get((int) (Math.random() * p.getParkedCars().size())).leaveParking(p);
        p.getParkedCars().get((int) (Math.random() * p.getParkedCars().size())).leaveParking(p);
        p.getParkedCars().get((int) (Math.random() * p.getParkedCars().size())).leaveParking(p);
    }
}
