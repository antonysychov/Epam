package HomeWork.HomeWork12.Task2;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> q = new LinkedList<T>();
    int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T element) {
        synchronized (this) {
            while (getQ().size() >= maxSize) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            getQ().add(element);
            this.notify();
        }
    }

    public T remove() {
        T element = null;
        synchronized (this) {
            while (getQ().size() == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            element = (T) getQ().remove();
            this.notify();
        }
        return element;
    }

    public void remove(T element) {
        synchronized (this) {
            q.remove(element);
            this.notify();
        }
    }

    public Queue getQ() {
        return q;
    }

    public void setQ(Queue q) {
        this.q = q;
    }
}
