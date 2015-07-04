package HomeWork.HomeWork13.Task6;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> sq = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        sq.take();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(5000);
                    sq.take();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    sq.put(5);
                    Thread.sleep(100);
                    sq.put(32);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
