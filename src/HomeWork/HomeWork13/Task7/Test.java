package HomeWork.HomeWork13.Task7;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    linkedBlockingQueue.add(1);
                    linkedBlockingQueue.add(2);
                    linkedBlockingQueue.add(3);
                    linkedBlockingQueue.add(4);
                    linkedBlockingQueue.add(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(linkedBlockingQueue.getNRemove());
                    System.out.println(linkedBlockingQueue.getNRemove());
                    System.out.println(linkedBlockingQueue.getNRemove());
                    System.out.println(linkedBlockingQueue.getNRemove());
                    System.out.println(linkedBlockingQueue.getNRemove());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
