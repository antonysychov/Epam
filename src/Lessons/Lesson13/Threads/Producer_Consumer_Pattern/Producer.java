package Lessons.Lesson13.Threads.Producer_Consumer_Pattern;

public class Producer extends Thread {
    MyQueue q;

    public Producer(MyQueue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            Integer element = 1;
            q.add(element);
            System.out.println("we put element");
        }
    }
}
