package Lessons.Lesson16.Concurrent.CyclicBarrier;

public class Barrier {
    int count;

    public Barrier(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        count--;
        while (count > 0) {
            wait();
        }
        notifyAll();

    }
}
