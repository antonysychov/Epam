package Lessons.Lesson14.Threads.ThreadLocal;

public class MyThread implements Runnable {
    ThreadLocal<Integer> tl;
    int value;

    public MyThread(ThreadLocal tl, int value) {
        this.tl = tl;
        this.value = value;
    }

    @Override
    public void run() {
        tl.set(new Integer(value));
        int v = tl.get();
        System.out.println(v);
    }

    public static void main(String[] args) {
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        MyThread m = new MyThread(tl, 10);
        MyThread m1 = new MyThread(tl, 20);
        new Thread(m).start();
        new Thread(m1).start();
    }
}
