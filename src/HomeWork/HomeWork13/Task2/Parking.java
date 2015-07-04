package HomeWork.HomeWork13.Task2;

import java.util.LinkedList;
import java.util.List;

public class Parking {
    private int spots;
    private List<Car> parkedCars = new LinkedList<>();

    public Parking(int spots) {
        this.spots = spots;
    }

    public synchronized boolean placeCar(Car c, int secondsToWait) {
        while (spots <= parkedCars.size()) {
            try {
                wait(secondsToWait * 1000);
                if (spots <= parkedCars.size()) {
                    System.out.println("Car " + c + " went away since there were no available spots");
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        parkedCars.add(c);
        System.out.println("Car " + c + " has occupied parking spot");
        return true;
    }

    public synchronized boolean releaseCar(Car c) {
        if (parkedCars.contains(c)) {
            parkedCars.remove(c);
            notify();
            return true;
        } else {
            System.out.println("There is no such car");
            return false;
        }
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }
}
