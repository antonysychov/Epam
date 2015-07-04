package HomeWork.HomeWork12.Task2;

import HomeWork.HomeWork12.Task2.Cookers.BorschtCooker;
import HomeWork.HomeWork12.Task2.Cookers.CakeCooker;
import HomeWork.HomeWork12.Task2.Cookers.CoffeeCooker;
import HomeWork.HomeWork12.Task2.Cookers.Cooker;
import HomeWork.HomeWork12.Task2.Items.Borscht;
import HomeWork.HomeWork12.Task2.Items.Cake;
import HomeWork.HomeWork12.Task2.Items.Coffee;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private static volatile int tableCount = 5;

    public static MyQueue<Borscht> preparedBorschts = new MyQueue<>(tableCount);
    public static MyQueue<Cake> preparedCakes = new MyQueue<>(tableCount);
    public static MyQueue<Coffee> preparedCoffees = new MyQueue<>(tableCount);
    public static MyQueue<Client> clients = new MyQueue<>(tableCount);
    public static List<Cooker> cookers = new LinkedList<Cooker>() {{
        add(new BorschtCooker());
        add(new CakeCooker());
        add(new CoffeeCooker());
    }};

    public static void main(String[] args) {
        acceptNewClient(new Client(1));
        acceptNewClient(new Client(2));
        acceptNewClient(new Client(3));
        acceptNewClient(new Client(4));
        acceptNewClient(new Client(6));
        acceptNewClient(new Client(7));
        acceptNewClient(new Client(8));
        acceptNewClient(new Client(9));
        acceptNewClient(new Client(10));
        acceptNewClient(new Client(11));
    }

    public static void acceptNewClient(Client c) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (clients) {
                    while (clients.getQ().size() >= tableCount) {
                        try {
                            System.out.println(String.format("Client %d is waiting", c.getNumber()));
                            clients.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    clients.add(c);
                    System.out.println(String.format("Client %d made order", c.getNumber()));
                }
                informCookers();
                feedClient(c);
                clients.remove(c);
                System.out.println("Client " + c.getNumber() + " has finished");
            }
        }).start();
    }

    private static void feedClient(Client c) {
        c.eatBorscht();
        c.eatCake();
        c.drinkCofee();
    }

    private static void informCookers() {
        for (Cooker cooker : cookers) {
            cooker.cook();
        }
    }

    public static class Client {
        private int number;

        public Client(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void eatBorscht() {
            preparedBorschts.remove();
            System.out.println(String.format("Client %d is eating borscht", number));
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void eatCake() {
            preparedCakes.remove();
            System.out.println(String.format("Client %d is eating cake", number));
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void drinkCofee() {
            preparedCoffees.remove();
            System.out.println(String.format("Client %d is drinking coofee", number));
            try {
                TimeUnit.SECONDS.sleep(7);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
