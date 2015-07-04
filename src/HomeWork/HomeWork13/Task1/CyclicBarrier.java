package HomeWork.HomeWork13.Task1;

import java.util.LinkedList;
import java.util.List;

public class CyclicBarrier {
    private List<Thread> waitingThreads = new LinkedList<>();
    private int queueSize;
    private int count;
    private Runnable thread;

    public CyclicBarrier(Runnable thread, int queueSize) {
        this.thread = thread;
        this.count = queueSize;
        this.queueSize = queueSize;
    }

    public synchronized void await() throws InterruptedException {
        waitingThreads.add(Thread.currentThread());
        count--;
        while (count > 0) {
            wait();
        }
        notifyAll();
        waitingThreads.remove(Thread.currentThread());
        if (count-- == 0) thread.run();
        if (waitingThreads.isEmpty()) {
            reset();
        }
    }

    public void reset() {
        count = queueSize;
    }
}
