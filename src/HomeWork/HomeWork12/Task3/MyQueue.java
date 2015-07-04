package HomeWork.HomeWork12.Task3;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue q = new LinkedList<>();
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
            this.notifyAll();
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
            this.notifyAll();
        }
        return element;
    }

    public Queue getQ() {
        return q;
    }

    public void setQ(Queue q) {
        this.q = q;
    }
}
