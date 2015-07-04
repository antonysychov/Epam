package HomeWork.HomeWork3.Task2;

public class Test {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        System.out.println("After inserting");
        tree.print();
        tree.delete(2);
        tree.delete(3);
        tree.delete(6);
        System.out.println("After deletion");
        tree.print();
    }
}


