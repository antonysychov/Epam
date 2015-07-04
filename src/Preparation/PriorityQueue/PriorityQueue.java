package Preparation.PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> {
    private BinaryHeap<E> binaryHeap = new BinaryHeap<E>(new ArrayList<E>());

    public void add(E el) {
        binaryHeap.add(el);
    }

    public E extractMax() {
        return binaryHeap.extractMax();
    }

    public static class BinaryHeap<E extends Comparable<E>> {
        private List<E> array;

        public BinaryHeap(List<E> array) {
            this.array = array;
        }

        public int getSize() {
            return array.size();
        }

        public void add(E element) {

            array.add(element);

            int pos = getSize() - 1;
            if (pos == 0) return;

            int parentPos = (pos - 1) / 2;

            while (pos > 0 && array.get(parentPos).compareTo(array.get(pos)) < 0) {
                swapElements(parentPos, pos);

                parentPos = (parentPos - 1) / 2;
                pos = parentPos;
            }
        }

        public E extractMax() {
            E result = array.get(0);
            int last = getSize() - 1;
            array.set(0, array.get(last));
            array.remove(last);
            heapify(0);
            return result;
        }

        public void heapify(int root) {

            while (true) {

                int leftChild = root * 2 + 1;
                int rightChild = root * 2 + 2;

                if (leftChild < getSize() && array.get(leftChild).compareTo(array.get(root)) > 0) {
                    swapElements(leftChild, root);
                    root = leftChild;
                } else if (rightChild < getSize() && array.get(rightChild).compareTo(array.get(root)) > 0) {
                    swapElements(rightChild, root);
                    root = rightChild;
                } else break;
            }
        }

        private void swapElements(int i1, int i2) {
            E temp = array.get(i1);
            array.set(i1, array.get(i2));
            array.set(i2, temp);
        }
    }
}
