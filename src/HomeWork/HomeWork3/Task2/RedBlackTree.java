package HomeWork.HomeWork3.Task2;

public class RedBlackTree<DataType extends Comparable> {

    public Node<DataType> root;

    public RedBlackTree() {
        root = null;
    }

    private Color nodeColor(Node<DataType> n) {
        return n == null ? Color.BLACK : n.color;
    }

    private Node<DataType> findNodeByKey(DataType key) {
        Node<DataType> n = root;
        while (n != null) {
            int compResult = key.compareTo(n.key);
            if (compResult == 0) {
                return n;
            } else if (compResult < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return n;
    }

    private void rotateLeft(Node<DataType> n) {
        Node<DataType> r = n.right;
        replaceNode(n, r);
        n.right = r.left;
        if (r.left != null) {
            r.left.parent = n;
        }
        r.left = n;
        n.parent = r;
    }

    private void rotateRight(Node<DataType> n) {
        Node<DataType> l = n.left;
        replaceNode(n, l);
        n.left = l.right;
        if (l.right != null) {
            l.right.parent = n;
        }
        l.right = n;
        n.parent = l;
    }

    private void replaceNode(Node<DataType> oldn, Node<DataType> newn) {
        if (oldn.parent == null) {
            root = newn;
        } else {
            if (oldn == oldn.parent.left)
                oldn.parent.left = newn;
            else
                oldn.parent.right = newn;
        }
        if (newn != null) {
            newn.parent = oldn.parent;
        }
    }

    public void insert(DataType key) {
        Node<DataType> insertedNode = new Node<DataType>(key, Color.RED, null, null);
        if (root == null) {
            root = insertedNode;
        } else {
            Node<DataType> n = root;
            while (true) {
                int compResult = key.compareTo(n.key);
                if (compResult == 0) {
                    n.key = key;
                    return;
                } else if (compResult < 0) {
                    if (n.left == null) {
                        n.left = insertedNode;
                        break;
                    } else {
                        n = n.left;
                    }
                } else {
                    if (n.right == null) {
                        n.right = insertedNode;
                        break;
                    } else {
                        n = n.right;
                    }
                }
            }
            insertedNode.parent = n;
        }
        insertCase1(insertedNode);
    }

    private void insertCase1(Node<DataType> n) {
        if (n.parent == null)
            n.color = Color.BLACK;
        else
            insertCase2(n);
    }

    private void insertCase2(Node<DataType> n) {
        if (nodeColor(n.parent) == Color.BLACK)
            return; // Tree is still valid
        else
            insertCase3(n);
    }

    private void insertCase3(Node<DataType> n) {
        if (nodeColor(n.uncle()) == Color.RED) {
            n.parent.color = Color.BLACK;
            n.uncle().color = Color.BLACK;
            n.grandparent().color = Color.RED;
            insertCase1(n.grandparent());
        } else {
            insertCase4(n);
        }
    }

    private void insertCase4(Node<DataType> n) {
        if (n == n.parent.right && n.parent == n.grandparent().left) {
            rotateLeft(n.parent);
            n = n.left;
        } else if (n == n.parent.left && n.parent == n.grandparent().right) {
            rotateRight(n.parent);
            n = n.right;
        }
        insertCase5(n);
    }

    private void insertCase5(Node<DataType> n) {
        n.parent.color = Color.BLACK;
        n.grandparent().color = Color.RED;
        if (n == n.parent.left && n.parent == n.grandparent().left) {
            rotateRight(n.grandparent());
        } else {
            rotateLeft(n.grandparent());
        }
    }

    public void delete(DataType key) {
        Node<DataType> n = findNodeByKey(key);
        if (n == null)
            return;  // Key not found, do nothing
        if (n.left != null && n.right != null) {
            // Copy key from predecessor and then delete it instead
            Node<DataType> pred = maximumNode(n.left);
            n.key = pred.key;
            n = pred;
        }

        Node<DataType> child = (n.right == null) ? n.left : n.right;
        if (nodeColor(n) == Color.BLACK) {
            n.color = nodeColor(child);
            deleteCase1(n);
        }
        replaceNode(n, child);
    }

    private <DataType extends Comparable> Node<DataType> maximumNode(Node<DataType> n) {
        while (n.right != null) {
            n = n.right;
        }
        return n;
    }

    private void deleteCase1(Node<DataType> n) {
        if (n.parent != null)
            deleteCase2(n);
    }

    private void deleteCase2(Node<DataType> n) {
        if (nodeColor(n.sibling()) == Color.RED) {
            n.parent.color = Color.RED;
            n.sibling().color = Color.BLACK;
            if (n == n.parent.left)
                rotateLeft(n.parent);
            else
                rotateRight(n.parent);
        }
        deleteCase3(n);
    }

    private void deleteCase3(Node<DataType> n) {
        if (nodeColor(n.parent) == Color.BLACK &&
                nodeColor(n.sibling()) == Color.BLACK &&
                nodeColor(n.sibling().left) == Color.BLACK &&
                nodeColor(n.sibling().right) == Color.BLACK) {
            n.sibling().color = Color.RED;
            deleteCase1(n.parent);
        } else
            deleteCase4(n);
    }

    private void deleteCase4(Node<DataType> n) {
        if (nodeColor(n.parent) == Color.RED &&
                nodeColor(n.sibling()) == Color.BLACK &&
                nodeColor(n.sibling().left) == Color.BLACK &&
                nodeColor(n.sibling().right) == Color.BLACK) {
            n.sibling().color = Color.RED;
            n.parent.color = Color.BLACK;
        } else
            deleteCase5(n);
    }

    private void deleteCase5(Node<DataType> n) {
        if (n == n.parent.left &&
                nodeColor(n.sibling()) == Color.BLACK &&
                nodeColor(n.sibling().left) == Color.RED &&
                nodeColor(n.sibling().right) == Color.BLACK) {
            n.sibling().color = Color.RED;
            n.sibling().left.color = Color.BLACK;
            rotateRight(n.sibling());
        } else if (n == n.parent.right &&
                nodeColor(n.sibling()) == Color.BLACK &&
                nodeColor(n.sibling().right) == Color.RED &&
                nodeColor(n.sibling().left) == Color.BLACK) {
            n.sibling().color = Color.RED;
            n.sibling().right.color = Color.BLACK;
            rotateLeft(n.sibling());
        }
        deleteCase6(n);
    }

    private void deleteCase6(Node<DataType> n) {
        n.sibling().color = nodeColor(n.parent);
        n.parent.color = Color.BLACK;
        if (n == n.parent.left) {
            n.sibling().right.color = Color.BLACK;
            rotateLeft(n.parent);
        } else {
            n.sibling().left.color = Color.BLACK;
            rotateRight(n.parent);
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node<DataType> node) {
        System.out.println(node);
        if (node.right != null) print(node.right);
        if (node.left != null) print(node.left);
    }

    public enum Color {
        RED, BLACK;
    }

    class Node<DataType extends Comparable> {
        public DataType key;
        public Node<DataType> left;
        public Node<DataType> right;
        public Node<DataType> parent;
        public Color color;

        public Node(DataType key, Color nodeColor, Node<DataType> left, Node<DataType> right) {
            this.key = key;
            this.color = nodeColor;
            this.left = left;
            this.right = right;
            if (left != null) left.parent = this;
            if (right != null) right.parent = this;
            this.parent = null;
        }

        public Node<DataType> grandparent() {
            return parent.parent;
        }

        public Node<DataType> sibling() {
            if (this == parent.left)
                return parent.right;
            else
                return parent.left;
        }

        public Node<DataType> uncle() {
            return parent.sibling();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + ((left != null) ? left.key : null) +
                    ", right=" + ((right != null) ? right.key : null) +
                    ", parent=" + ((parent != null) ? parent.key : null) +
                    ", color=" + color +
                    '}';
        }
    }

}