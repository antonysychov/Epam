package HomeWork.HomeWork12.Task2.Cookers;

import HomeWork.HomeWork12.Task2.Items.Borscht;
import HomeWork.HomeWork12.Task2.Restaurant;

public class BorschtCooker extends Cooker {
    @Override
    public synchronized void cook() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Borscht cooker is cooking");
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Restaurant.preparedBorschts.add(new Borscht());
            }
        }).start();
    }
}
