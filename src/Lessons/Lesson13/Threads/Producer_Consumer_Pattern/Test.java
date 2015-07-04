package Lessons.Lesson13.Threads.Producer_Consumer_Pattern;

public class Test {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(4);
        Producer p1 = new Producer(q);
        Producer p2 = new Producer(q);
        Producer p3 = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }
}
