package HomeWork.HomeWork3.Task3;

public class Test {
    public static void main(String[] args) throws Exception {
        AVLTree<Integer> t = new AVLTree<>();
        t.insert(3);
        t.insert(1);
        t.insert(6);
        t.insert(0);
        t.remove(0);
        t.printTree();
    }

}
