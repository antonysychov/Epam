package HomeWork.HomeWork3.Task3;

public class AVLTree<Type extends Comparable<? super Type>> {

    private Node<Type> root;

    public AVLTree() {
        root = null;
    }

    public void insert(Type x) {
        if (root == null) {
            root = new Node<>(x, null, null);
            return;
        }
        Node<Type> t = root;

        label:
        do {
            int compareResult = x.compareTo(t.element);

            if (compareResult < 0) {
                if ((t.left) == null) {
                    t.left = new Node<>(x, null, null);
                    break label;
                }
                t = t.left;
            } else if (compareResult > 0) {
                if ((t.right) == null) {
                    t.right = new Node<>(x, null, null);
                    break label;
                }
                t = t.right;
            } else {
                break label;
            }
        }
        while (true);
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
                t = rotateRight(t);
            else
                t = doubleRightRotate(t);
        else if (height(t.right) - height(t.left) > 1)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateLeft(t);
            else
                t = doubleLeftRotate(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private Node<Type> getMin(Node<Type> t) {
        if (t == null)
            return t;

        while (t.left != null)
            t = t.left;
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

    private Node<Type> rotateRight(Node<Type> k2) {
        Node<Type> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private Node<Type> rotateLeft(Node<Type> k1) {
        Node<Type> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private Node<Type> doubleRightRotate(Node<Type> k3) {
        k3.left = rotateLeft(k3.left);
        return rotateRight(k3);
    }

    private Node<Type> doubleLeftRotate(Node<Type> k1) {
        k1.right = rotateRight(k1.right);
        return rotateLeft(k1);
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

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    ", height=" + height +
                    '}';
        }
    }
}
