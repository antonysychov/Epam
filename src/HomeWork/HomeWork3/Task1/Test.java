package HomeWork.HomeWork3.Task1;

public class Test {

    public static void main(String[] args) {

        PriorityQueue<String> queue = new PriorityQueue<String>();

        queue.add(2, "��������� 2");
        queue.add(8, "��������� 8");
        queue.add(99, "��������� 99");

        queue.add(1, "��������� 1");
        queue.add(5, "��������� 5");

        queue.printQueue();
        System.out.println("������ � ������������ ����������� : " + queue.extractMax());     //element with max priority
        queue.printQueue();
        System.out.println("������ � ������������ ����������� : " + queue.extractMax());     //element with max priority
    }

}
