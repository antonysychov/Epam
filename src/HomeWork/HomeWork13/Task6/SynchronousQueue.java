package HomeWork.HomeWork13.Task6;

public class SynchronousQueue<E> {
    private E element;
    private Thread waitingToTake;
    private Thread waitingToPut;
    public final Object lock = new Object();

    public E take() throws Exception {
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " wants to take");
            if (waitingToTake != null) throw new Exception("Another thread is waiting to take");
            else {
                waitingToTake = Thread.currentThread();
            }
            lock.notify();
            while (waitingToPut == null || element == null) {
                lock.wait();
            }
            E temp = element;
            element = null;
            System.out.println(Thread.currentThread() + " took " + temp);
            lock.notify();
            waitingToTake = null;
            return temp;
        }
    }

    public void put(E e) throws Exception {
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " wants to put");
            if (waitingToPut != null) throw new Exception("Another thread is waiting to put");
            else {
                waitingToPut = Thread.currentThread();
            }
            lock.notify();
            while (waitingToTake == null) {
                lock.wait();
            }
            element = e;
            System.out.println(Thread.currentThread() + " put " + e);
            lock.notify();
            while (element != null) {
                lock.wait();
            }
            waitingToPut = null;
        }
    }
}
