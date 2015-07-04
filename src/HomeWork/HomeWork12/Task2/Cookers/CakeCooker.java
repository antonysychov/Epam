package HomeWork.HomeWork12.Task2.Cookers;

import HomeWork.HomeWork12.Task2.Items.Cake;
import HomeWork.HomeWork12.Task2.Restaurant;

public class CakeCooker extends Cooker{
    @Override
    public synchronized void cook() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Cake cooker is cooking");
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Restaurant.preparedCakes.add(new Cake());
            }
        }).start();
    }
}
