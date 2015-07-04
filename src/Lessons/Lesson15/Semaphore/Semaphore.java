package Lessons.Lesson15.Semaphore;

public class Semaphore {
    int value;

    public Semaphore(int value) {
        this.value = value;
    }

    public synchronized void acquire() throws InterruptedException {
        while (value == 0) {
            wait();
        }
        value--;
    }

    public synchronized void release() {
        value++;
        notify();
    }

}
