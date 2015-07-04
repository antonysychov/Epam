package HomeWork.HomeWork10;

import HomeWork.HomeWork10.Exceptions.EmptyListException;
import HomeWork.HomeWork10.Exceptions.FullListException;
import HomeWork.HomeWork10.Exceptions.NoSuchElementException;

public class LinkedList<T> {

    private final int limit;
    private Node first;
    private Node last;
    private int size = 0;

    public LinkedList(int limit) {
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

    public void addLast(T value) throws FullListException {
        if (limit <= size) throw new FullListException();
        if (size == 0) {
            first = last = new Node(value, null);
            size++;
        } else {
            last.next = new Node(value, null);
            last = last.next;
            size++;
        }
    }

    public void addFirst(T value) throws FullListException {
        if (limit <= size) throw new FullListException();
        first = new Node(value, first);
        size++;
    }

    public void add(int index, T value) throws FullListException, NoSuchElementException {
        if (limit <= size) throw new NoSuchElementException();
        if (index == (size - 1)) {
            addLast(value);
            return;
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node current = findNodeByIndex(index - 1);
        current.next = new Node(value, current.next);
        size++;
    }

    public void remove(int index) throws NoSuchElementException, EmptyListException {
        if (index > size - 1) throw new NoSuchElementException();
        if (index == 0) {
            removeFirst();
            return;
        }
        Node current = findNodeByIndex(index - 1);
        Node deletable = current.next;
        current.next = deletable.next;
        size--;
    }

    public void removeFirst() throws EmptyListException {
        if (size == 0) throw new EmptyListException();
        first = first.next;
        size--;
    }

    public T get(int index) throws NoSuchElementException {
        Node node = findNodeByIndex(index);
        return node.value;
    }

    private Node findNodeByIndex(int index) throws NoSuchElementException {
        if (size - 1 < index) throw new NoSuchElementException();
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public String toString() {
        Node current;
        StringBuffer sb = new StringBuffer();
        sb.append(current = first);
        while (current != null && (current = current.next) != null) {
            sb.append(" " + current);
        }
        return sb.toString();
    }
}
