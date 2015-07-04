package HomeWork.HomeWork3.backup;

public class AVLTree<Type extends Comparable<? super Type>> {

    private Node<Type> root;

    public AVLTree() {
        root = null;
    }

    public static void main(String[] args) throws Exception {
        AVLTree<Integer> t = new AVLTree<>();

    }

    public void insert(Type x) {
        root = insert(x, root);
        Node<Type> t = root;
        label:
        do {
            if (t == null)
                t = new Node<>(x, null, null);
            else {
                int compareResult = x.compareTo(t.element);

                if (compareResult < 0)
                    t.left = insert(x, t.left);
                else if (compareResult > 0)
                    t.right = insert(x, t.right);
            }
        }
        while (t != null);
        balance(t);
    }

    public void remove(Type x) {
        root = remove(x, root);
    }

    private Node<Type> remove(Type x, Node<Type> t) {
        if (t == null)
            return t;   // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = getMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return balance(t);
    }

    public Type getMin() throws Exception {
        if (isEmpty())
            throw new Exception("is empty");
        return getMin(root).element;
    }

    public Type getMax() throws Exception {
        if (isEmpty())
            throw new Exception("is empty");
        return getMax(root).element;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private Node<Type> balance(Node<Type> t) {
        if (t == null)
            return t;

        if (height(t.left) - height(t.right) > 1)
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else if (height(t.right) - height(t.left) > 1)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(Node<Type> t) {
        if (t == null)
            return -1;

        if (t != null) {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1 ||
                    height(t.left) != hl || height(t.right) != hr)
                System.out.println("OOPS!!");
        }

        return height(t);
    }

    private Node<Type> insert(Type x, Node<Type> t) {
        if (t == null)
            return new Node<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        return balance(t);
    }

    private Node<Type> getMin(Node<Type> t) {
        if (t == null)
            return t;

        while (t.left != null)
            t = t.left;
        return t;
    }

    private Node<Type> getMax(Node<Type> t) {
        if (t == null)
            return t;

        while (t.right != null)
            t = t.right;
        return t;
    }

    private void printTree(Node<Type> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(Node<Type> t) {
        return t == null ? -1 : t.height;
    }

    private Node<Type> rotateWithLeftChild(Node<Type> k2) {
        Node<Type> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private Node<Type> rotateWithRightChild(Node<Type> k1) {
        Node<Type> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root.
     */
    private Node<Type> doubleWithLeftChild(Node<Type> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     * Update heights, then return new root.
     */
    private Node<Type> doubleWithRightChild(Node<Type> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private static class Node<Type> {
        Type element;
        Node<Type> left;
        Node<Type> right;
        int height;

        Node(Type theElement) {
            this(theElement, null, null);
        }

        Node(Type theElement, Node<Type> lt, Node<Type> rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }
}
