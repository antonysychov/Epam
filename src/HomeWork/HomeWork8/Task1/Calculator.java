package HomeWork.HomeWork8.Task1;

import HomeWork.HomeWork8.Task1.PolishNotation.Unit;
import HomeWork.HomeWork8.Task1.PolishNotation.UnitType;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String input) {
        PolishNotation pn = new PolishNotation();
        pn.transform(input);
        LinkedList<PolishNotation.Unit> listOfUnits = pn.getListOfUnits();
        LinkedList<ComponentNode> listOfNodes = new LinkedList<>();
        CompositeTree tree = new CompositeTree();
        for (Unit u : listOfUnits) {
            listOfNodes.add(new ComponentNode(u, null, null, null));
        }

        for (int i = 0; i < listOfNodes.size(); i++) {
            if (listOfNodes.size() == 1) break;
            ComponentNode node = listOfNodes.get(i);
            if (node.key.type == UnitType.MINUS ||
                    node.key.type == UnitType.PLUS ||
                    node.key.type == UnitType.DIVIDE ||
                    node.key.type == UnitType.MULTIPLY) {
                if (tree.root == null) {
                    node.left = (listOfNodes.get(i - 2));
                    node.right = (listOfNodes.get(i - 1));
                    tree.add(node);
                    listOfNodes.remove(i);
                    listOfNodes.remove(i - 1);
                    listOfNodes.remove(i - 2);
                    i = i - 3;
                    continue;
                }
                Component comp = (listOfNodes.get(i - 1));
                switch (node.key.type) {
                    case PLUS:
                        tree.add(comp);
                        break;
                    case MINUS:
                        tree.subtract(comp);
                        break;
                    case MULTIPLY:
                        tree.multiply(comp);
                        break;
                    case DIVIDE:
                        tree.divide(comp);
                        break;
                }
                listOfNodes.remove(i);
                listOfNodes.remove(i - 1);
                i = i - 2;

            }
        }
        tree.print();
        return tree.calculate();
    }

    private abstract static class Component {

        Component parent;
        Component left;
        Component right;
        Unit key;

        abstract int calculate();

        abstract void print();
    }

    private class CompositeTree extends Component {

        Component root;
        List<Component> nodes = new LinkedList<>();

        @Override
        public void print() {
            root.print();
        }

        @Override
        public int calculate() {
            return root.calculate();
        }

        void add(Component c) {
            if (root == null) {
                root = c;
                return;
            }
            Unit unit = new Unit(2, "+", UnitType.PLUS);
            Component comp = new ComponentNode(unit, root, c, null);
            root.parent = comp;
            root = comp;
        }

        void subtract(Component c) {
            if (root == null) {
                throw new IllegalArgumentException("root is null");
            }
            Unit unit = new Unit(2, "-", UnitType.MINUS);
            Component comp = new ComponentNode(unit, root, c, null);
            root.parent = comp;
            root = comp;

        }

        void multiply(Component c) {
            if (root == null) {
                throw new IllegalArgumentException("root is null");
            }
            Unit unit = new Unit(3, "*", UnitType.MULTIPLY);
            Component comp = new ComponentNode(unit, root, c, null);
            root.parent = comp;
            root = comp;
        }

        void divide(Component c) {
            if (root == null) {
                throw new IllegalArgumentException("root is null");
            }
            Unit unit = new Unit(3, "/", UnitType.DIVIDE);
            Component comp = new ComponentNode(unit, root, c, null);
            root.parent = comp;
            root = comp;
        }

    }

    private class ComponentNode extends Component {

        public ComponentNode(Unit key, Component left, Component right, Component parent) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
            if (left != null) left.parent = this;
            if (right != null) right.parent = this;
            this.parent = null;
        }

        public void print() {
            print(this);
        }

        private void print(Component node) {
            System.out.println(node);
            if (node.right != null) print(node.right);
            if (node.left != null) print(node.left);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + ((left != null) ? left.key : null) +
                    ", right=" + ((right != null) ? right.key : null) +
                    ", parent=" + ((parent != null) ? parent.key : null) +
                    '}';
        }

        @Override
        public int calculate() {
            switch (key.type) {
                case MINUS:
                    return left.calculate() - right.calculate();
                case PLUS:
                    return left.calculate() + right.calculate();
                case MULTIPLY:
                    return left.calculate() * right.calculate();
                case DIVIDE:
                    return left.calculate() / right.calculate();
                case DIGIT:
                    return Integer.valueOf(key.unit);
            }
            try {
                throw new IllegalArgumentException("wrong character");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
