package Lessons.Lesson13.Threads.Synchronisation;

public class A extends Thread {
    Object o;

    public A(Object o) {
        this.o = o;
    }

    public void f() {
        synchronized (o) {
            System.out.println("hello");
        }
    }

    @Override
    public void run() {
        f();
    }
}

class Test {
    public static void main(String[] args) {
        Object o = new Object();
        A pa1 = new A(o);
        A pa2 = new A(o);
        pa1.start();
        pa2.start();
    }
}
