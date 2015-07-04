package Lessons.Lesson13.Threads.Producer_Consumer_Pattern;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    Queue q = new LinkedList<>();
    int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(Integer element) {
        synchronized (this) {
            while (q.size() >= maxSize) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            q.add(element);
            this.notifyAll();
        }
    }

    public Integer remove() {
        Integer element = null;
        synchronized (this) {
            while (q.size() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            element = (Integer) q.remove();
            this.notifyAll();
        }
        return element;
    }
}
