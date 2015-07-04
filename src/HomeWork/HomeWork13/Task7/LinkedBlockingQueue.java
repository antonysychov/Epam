package HomeWork.HomeWork13.Task7;

public class LinkedBlockingQueue<T> {

    private int limit;
    private Node head;
    private Node tail;
    private int size = 0;
    private final Object lock = new Object();

    public LinkedBlockingQueue(int limit) {
        this.limit = limit;
    }

    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public int getSize() {
        return size;
    }

    public void add(T value) throws InterruptedException {
        synchronized (lock) {
            while (size == limit) {
                lock.wait();
            }
            Node temp = new Node(value, null);
            if (tail != null) {
                tail.next = temp;
            }
            tail = temp;
            if (head == null) head = tail;
            size++;
            lock.notify();
        }
    }

    public T getNRemove() throws InterruptedException {
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }
            Node oldHead = head;
            head = head.next;
            size--;
            lock.notify();
            return oldHead.value;
        }
    }

    @Override
    public String toString() {
        Node current;
        StringBuilder sb = new StringBuilder();
        sb.append(current = head);
        while (current != null && (current = current.next) != null) {
            sb.append(" " + current);
        }
        return sb.toString();
    }
}
