package HomeWork.HomeWork13.Task3;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentQueue<E> {
    private AtomicReference<Pointer> Head = new AtomicReference<>();
    private AtomicReference<Pointer> Tail = new AtomicReference<>();

    public ConcurrentQueue() {
        Node<E> node = new Node<>();
        node.next = null;
        Head.set(new Pointer(node, 0));
        Tail.set(new Pointer(node, 0));
    }

    public void enqueue(E element) {
        Node<E> node = new Node<>();
        node.value = element;
        node.next = null;
        Pointer tail;
        Pointer next;
        while (true) {
            tail = Tail.get();
            next = tail.ptr.next;
            if (tail.equals(Tail.get())) {
                if (next == null) {
                    Pointer temp = new Pointer(node, 1);
                    tail.ptr.next = temp;
                    break;
                } else
                    Tail.compareAndSet(tail, new Pointer(next.ptr, tail.counter + 1));
            }
        }
        Tail.compareAndSet(tail, new Pointer(node, tail.counter + 1));
    }

    public E dequeue() throws Exception {
        E result;
        Pointer head;
        Pointer tail;
        while (true) {
            head = Head.get();
            tail = Tail.get();
            Pointer next = head.ptr.next;
            if (head == (Head.get())) {
                if (head.ptr == tail.ptr) {
                    if (next == null) {
                        throw new Exception("queue is empty");
                    }
                    Tail.compareAndSet(tail, new Pointer(next.ptr, tail.counter + 1));
                } else {
                    if (Head.compareAndSet(head, new Pointer(next.ptr, head.counter + 1))) {
                        break;
                    }
                }
            }
        }
        return head.ptr.next.ptr.value;
    }

    private class Node<E> {
        E value;
        Pointer next;

        public Node() {
        }

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private class Pointer {
        Node<E> ptr;
        int counter;

        public Pointer(Node ptr, int counter) {
            this.ptr = ptr;
            this.counter = counter;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pointer pointer = (Pointer) o;

            if (counter != pointer.counter) return false;
            return !(ptr != null ? !ptr.equals(pointer.ptr) : pointer.ptr != null);

        }

        @Override
        public int hashCode() {
            int result = ptr != null ? ptr.hashCode() : 0;
            result = 31 * result + counter;
            return result;
        }

        @Override
        public String toString() {
            return "Pointer{" +
                    "ptr=" + ptr +
                    ", counter=" + counter +
                    '}';
        }
    }

//    public void add(E item) {
//        Node<E> newBottom = new Node<E>(item);
//        Node<E> oldBottom;
//        do {
//            oldBottom = bottom.get();
//            if (oldBottom != null) {
//                oldBottom.next = newBottom;
//            }
//        } while (!bottom.compareAndSet(oldBottom, newBottom));
//        if (top.get() == null) top.compareAndSet(null, newBottom);
//    }
//
//    public E get() {
//        Node<E> oldTop;
//        Node<E> newTop;
//        do {
//            oldTop = top.get();
//            if (oldTop == null)
//                return null;
//            newTop = oldTop.next;
//        } while (!top.compareAndSet(oldTop, newTop));
//        return oldTop.item;
//    }
}