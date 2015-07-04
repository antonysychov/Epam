package HomeWork.HomeWork12.Task2.Cookers;

import HomeWork.HomeWork12.Task2.Items.Coffee;
import HomeWork.HomeWork12.Task2.Restaurant;

public class CoffeeCooker extends Cooker {
    @Override
    public synchronized void cook() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Coffee cooker is cooking");
                try {
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Restaurant.preparedCoffees.add(new Coffee());
            }
        }).start();
    }
}
