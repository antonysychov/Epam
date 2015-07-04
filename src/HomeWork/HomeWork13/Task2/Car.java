package HomeWork.HomeWork13.Task2;

public class Car {
    private int id;

    public Car(int id) {
        this.id = id;
    }

    public void enterParking(Parking p, int secondsToWait) {

        new Thread(new Runnable() {
            @Override
            public void run() {p.placeCar(Car.this, secondsToWait);
            }
        }).start();
    }

    public void leaveParking(Parking p) {
        p.releaseCar(this);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
