package HomeWork.HomeWork2.Task1;

public class Test {
    public static void main(String[] args) throws Exception {

        Container<String> arrayBased = new LinkedListDemo<>();
        Container<String> listBased = new ArrayList<>();

        Set<String> set1 = new Set<>(arrayBased);
        Set<String> set2 = new Set<>(listBased);

        //set1.add(11);
        set1.add("Киев");
        set1.add("Днепропетровск");
        set1.add("Харьков");

        set2.add("Львов");
        set2.add("Харьков");
        set2.add("Черновцы");

        System.out.println(set1);
        System.out.println(set2);

        set1.union(set2);

        System.out.println(set1);
    }
}

class LinkedListDemo<DataType> implements Container<DataType> {

    private Link first = null;
    private Link last = null;
    private int size = 0;

    void addFirst(DataType object) {
        Link temp = new Link(object, first, null);
        first = temp;
        size++;
        if (size == 1) last = temp;
    }

    void addLast(DataType object) {
        Link temp = new Link(object, null, last);
        if (size == 0)
            last = temp;
        else {
            last.next = temp;
            last = temp;
        }
        size++;
        if (size == 1) first = temp;
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
        Link current = first;
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
        Link current = first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        current.previous.next = current.next;
        current = null;
        if ((--size) == 0) {
            first = null;
            last = null;
        }
    }

    void removeFirst() {
        if (size == 0) return;
        first = first.next;
        if ((--size) == 0) {
            first = null;
            last = null;
        }
    }

    void removeLast() {
        if (size == 0) return;
        last = last.previous;
        if ((--size) == 0) {
            first = null;
            last = null;
        }
    }

    public DataType get(int position) {
        Link current = first;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.object;
    }

    public DataType getFirst() {
        return first.object;
    }

    public DataType getLast() {
        return last.object;
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
}

class ArrayList<DataType> implements Container<DataType> {

    java.util.ArrayList<DataType> arrayList = new java.util.ArrayList<DataType>();

    @Override
    public int getSize() {
        return arrayList.size();
    }

    @Override
    public DataType get(int index) {
        return arrayList.get(index);
    }

    @Override
    public void add(DataType data) {
        arrayList.add(data);
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}