package HomeWork.HomeWork3.Task1;

public class Test {

    public static void main(String[] args) {

        PriorityQueue<String> queue = new PriorityQueue<String>();

        queue.add(2, "Приоритет 2");
        queue.add(8, "Приоритет 8");
        queue.add(99, "Приоритет 99");

        queue.add(1, "Приоритет 1");
        queue.add(5, "Приоритет 5");

        queue.printQueue();
        System.out.println("Задача с максимальным приоритетам : " + queue.extractMax());     //element with max priority
        queue.printQueue();
        System.out.println("Задача с максимальным приоритетам : " + queue.extractMax());     //element with max priority
    }

}
