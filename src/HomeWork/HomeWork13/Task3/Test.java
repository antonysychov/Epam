package HomeWork.HomeWork13.Task3;

public class Test {
    public static void main(String[] args) throws Exception {
        ConcurrentQueue<Integer> cqi = new ConcurrentQueue<>();
        cqi.enqueue(1);
        cqi.enqueue(2);
        cqi.enqueue(3);
        cqi.enqueue(4);
        cqi.enqueue(5);
        System.out.println(cqi.dequeue());
        System.out.println(cqi.dequeue());
        System.out.println(cqi.dequeue());
        System.out.println(cqi.dequeue());
        System.out.println(cqi.dequeue());
        System.out.println(cqi.dequeue());
    }
}
