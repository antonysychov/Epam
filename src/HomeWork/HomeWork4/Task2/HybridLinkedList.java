package HomeWork.HomeWork4.Task2;

class HybridLinkedList<DataType> {

    private Link first = null;
    private Link last = null;
    private int size = 0;
    private int n = 0;
    public HybridLinkedList(int n) {
        this.n = n;
    }

    public void addLast(DataType object) {
        if (size == 0) {
            DataType[] array = (DataType[]) new Object[4];
            Link temp = new Link(array, null, last);
            last = temp;
            first = temp;
            last.object[last.filled] = object;
            last.filled++;
            ++size;
        } else {
            if (last.filled < n) {
                last.object[last.filled] = object;
                last.filled++;
            } else {
                DataType[] array = (DataType[]) new Object[4];
                Link temp = new Link(array, null, last);
                last.next = temp;
                last = temp;
                last.object[last.filled] = object;
                last.filled++;
                size++;
            }

        }
    }

    public void add(DataType data) {
        addLast(data);
    }

    public void add(DataType data, int position) {
        shiftRight(position);
        insert(data, position);
    }

    void removeLast() {
        if (size == 0) return;
        last.object[last.filled] = null;
        last.filled--;
        if (last.filled == 0) {
            last = last.previous;
            if ((--size) == 0) {
                first = null;
                last = null;
            }
        }
    }

    void remove(int position) {
        shiftLeft(position);
    }

    public DataType get(int position) {
        int nodeNumber = position / n;
        int arrayElement = position % n;
        Link current = first;
        for (int i = 0; i < nodeNumber; i++) {
            current = current.next;
        }
        return current.object[arrayElement];
    }

    public DataType getFirst() {
        return first.object[0];
    }

    public DataType getLast() {
        return last.object[last.filled - 1];
    }

    public int getSize() {
        return (size - 1) * 4 + last.filled;
    }

    private void insert(DataType object, int position) {
        int nodeNumber = position / 4;
        int arrayElement = position % 4;
        Link current = first;
        for (int i = 0; i < nodeNumber; i++) {
            current = current.next;
        }
        current.object[arrayElement] = object;
    }

    private void shiftRight(int start) {
        if (last.filled == n) {
            DataType[] array = (DataType[]) new Object[4];
            Link temp = new Link(array, null, last);
            last.next = temp;
            last = temp;
            last.filled++;
            size++;
        }
        int nodeNumber = start / 4;
        int arrayElement = start % 4 - 1;

        Link current = last;
        for (int i = size - 1; i >= nodeNumber; i--) {
            if (i == nodeNumber) {
                for (int j = n - 1; j > arrayElement; j--) {
                    current.object[j] = current.object[j - 1];
                }
                return;
            }
            current.filled++;
            for (int j = n - 1; j >= 1; j--) {
                current.object[j] = current.object[j - 1];
            }
            current.object[0] = current.previous.object[n - 1];
            current = current.previous;
        }
    }

    private void shiftLeft(int start) {

        int nodeNumber = start / 4;
        int arrayElement = start % 4;

        Link current = first;
        for (int i = 0; i < nodeNumber; i++) {
            current = current.next;
        }

        label:
        for (int i = nodeNumber; i < size; i++) {
            if (i == nodeNumber) {
                for (int j = arrayElement; j < n - 1; j++) {
                    current.object[j] = current.object[j + 1];
                }
                current.object[n - 1] = current.next.object[0];
                current = current.next;
                continue label;
            }

            for (int j = 0; j < n - 1; j++) {
                current.object[j] = current.object[j + 1];
            }
            if (current.next != null) current.object[n - 1] = current.next.object[0];
            if (i == size - 1) {
                if (--current.filled == 0) {
                    last.previous.next = null;
                    last = last.previous;
                    size--;
                }
                break label;
            }
            current = current.next;
        }

    }

    @Override
    public String toString() {
        int i = 0;
        StringBuffer sout = new StringBuffer();
        while (i < getSize()) {
            sout.append(get(i) + " ");
            i++;
        }
        return sout.toString();
    }

    private class Link {
        DataType[] object;
        Link next;
        Link previous;
        int filled = 0;

        public Link(DataType[] object, Link next, Link previous) {
            this.object = object;
            this.next = next;
            this.previous = previous;
            this.filled = 0;
        }
    }
}