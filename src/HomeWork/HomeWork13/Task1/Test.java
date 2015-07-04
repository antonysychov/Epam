package HomeWork.HomeWork13.Task1;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        }, 5);

        for (int i = 0; i < 12; i++) {
            Thread.sleep(1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "started");
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "completed");
                }
            }).start();
        }
    }
}
