package Preparation.NonBlockingArrayQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class NonBlockingQueue<T> {
    private AtomicReferenceArray<T> atomicArray;
    private AtomicInteger tail = new AtomicInteger();
    private AtomicInteger first = new AtomicInteger();
    private AtomicInteger size = new AtomicInteger();

    public NonBlockingQueue(int length) {
        atomicArray = new AtomicReferenceArray<T>(length);
    }

    public void offer(T element) throws ListFullException {
        int s = size.get();
        while (temp != atomicArray.length()) {
            if (tail.compareAndSet(temp, (temp + 1) % atomicArray.length())) {
                if (size.compareAndSet(s))
                atomicArray.set(temp, element);
            }
            temp = tail.get();
        }
        throw new ListFullException();
    }

    public T poll() throws ListEmptyException {
        T t = atomicArray.get(0);
    }
}
