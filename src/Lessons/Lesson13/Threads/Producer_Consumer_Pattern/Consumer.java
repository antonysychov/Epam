package Lessons.Lesson13.Threads.Producer_Consumer_Pattern;

public class Consumer extends Thread {
    MyQueue q;

    public Consumer(MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            Integer element = q.remove();
            System.out.println("we took the element" + element);
        }
    }
}
