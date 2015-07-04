package HomeWork.HomeWork4.Task2;

public class Test {


    public static void main(String[] args) {
        HybridLinkedList<String> list = new HybridLinkedList<>(4);

        list.add("1");
        list.add("2");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        System.out.println(list);

        list.add("3", 2);

        System.out.println(list);

        list.remove(2);

        System.out.println(list);

    }
}
