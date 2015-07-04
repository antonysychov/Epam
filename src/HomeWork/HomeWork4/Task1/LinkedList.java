package HomeWork.HomeWork4.Task1;

import HomeWork.HomeWork2.Task1.Container;

class LinkedList<DataType> implements Container<DataType> {

    private int size = 0;
    private Header header = new Header();

    void addFirst(DataType object) {
        Link temp = new Link(object, header.first, null);
        header.first = temp;
        size++;
        if (size == 1) header.last = temp;
    }

    void addLast(DataType object) {
        Link temp = new Link(object, null, header.last);
        if (size == 0)
            header.last = temp;
        else {
            header.last.next = temp;
            header.last = temp;
        }
        size++;
        if (size == 1) header.first = temp;
    }

    void add(DataType o, int position) {
        if (position == 0) {
            addFirst(o);
            return;
        }
        if (position == size) {
            addLast(o);
            return;
        }
        Link current = header.first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        Link temp = new Link(o, current, current.previous);
        current.previous.next = temp;
        current = temp;
        size++;
    }

    void remove(int position) {
        if (size == 0) return;
        Link current = header.first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.previous.next = current.next;
        current = null;
        if ((--size) == 0) {
            header.first = null;
            header.last = null;
        }
    }

    void removeFirst() {
        if (size == 0) return;
        header.first = header.first.next;
        if ((--size) == 0) {
            header.first = null;
            header.last = null;
        }
    }

    void removeLast() {
        if (size == 0) return;
        header.last = header.last.previous;
        if ((--size) == 0) {
            header.first = null;
            header.last = null;
        }
    }

    public DataType get(int position) {
        Link current = header.first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.object;
    }

    public DataType getFirst() {
        return header.first.object;
    }

    public DataType getLast() {
        return header.last.object;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(DataType data) {
        addLast(data);
    }

    @Override
    public String toString() {
        int i = 0;
        StringBuffer sout = new StringBuffer();
        while (i < size) {
            sout.append(get(i) + " ");
            i++;
        }
        return sout.toString();
    }

    private class Link {
        DataType object;
        Link next;
        Link previous;

        public Link(DataType object, Link next, Link previous) {
            this.object = object;
            this.next = next;
            this.previous = previous;
        }
    }

    private class Header {
        private Link first = null;
        private Link last = null;
    }
}

