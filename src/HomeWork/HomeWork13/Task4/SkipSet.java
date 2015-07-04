package HomeWork.HomeWork13.Task4;

public class SkipSet<E extends Comparable<? super E>> {
    public static final double P = 0.5;
    public static final int MAX_LEVEL = 6;
    public final SkipNode<E> header = new SkipNode<E>(MAX_LEVEL, null);
    public int currentMaxLevel = 0;

    public static int randomLevel() {
        int lvl = (int) (Math.log(1. - Math.random()) / Math.log(1. - P));
        return Math.min(lvl, MAX_LEVEL);
    }

    public boolean contains(E searchValue) {
        SkipNode<E> x = header;
        for (int i = currentMaxLevel; i >= 0; i--) {
            while (x.tower[i] != null && x.tower[i].value.compareTo(searchValue) < 0) {
                x = x.tower[i];
            }
        }
        x = x.tower[0];
        return x != null && x.value.equals(searchValue);
    }

    public void insert(E value) {
        SkipNode<E> x = header;
        SkipNode<E>[] update = new SkipNode[MAX_LEVEL + 1];

        for (int i = currentMaxLevel; i >= 0; i--) {
            while (x.tower[i] != null && x.tower[i].value.compareTo(value) < 0) {
                x = x.tower[i];
            }
            update[i] = x;
        }
        x = x.tower[0];

        if (x == null || !x.value.equals(value)) {
            int lvl = randomLevel();

            if (lvl > currentMaxLevel) {
                for (int i = currentMaxLevel + 1; i <= lvl; i++) {
                    update[i] = header;
                }
                currentMaxLevel = lvl;
            }
            x = new SkipNode<E>(lvl, value);
            for (int i = 0; i <= lvl; i++) {
                x.tower[i] = update[i].tower[i];
                update[i].tower[i] = x;
            }
        }
    }

    public void delete(E value) {
        SkipNode<E> x = header;
        SkipNode<E>[] update = new SkipNode[MAX_LEVEL + 1];

        for (int i = currentMaxLevel; i >= 0; i--) {
            while (x.tower[i] != null && x.tower[i].value.compareTo(value) < 0) {
                x = x.tower[i];
            }
            update[i] = x;
        }
        x = x.tower[0];

        if (x.value.equals(value)) {
            for (int i = 0; i <= currentMaxLevel; i++) {
                if (update[i].tower[i] != x)
                    break;
                update[i].tower[i] = x.tower[i];
            }
            while (currentMaxLevel > 0 && header.tower[currentMaxLevel] == null) {
                currentMaxLevel--;
            }
        }
    }

    class SkipNode<E extends Comparable<? super E>> {
        public final E value;
        public final SkipNode<E>[] tower; // array of pointers

        public SkipNode(int level, E value) {
            tower = new SkipNode[level + 1];
            this.value = value;
        }

        @Override
        public String toString() {
            return "SkipNode{" +
                    "value=" + value +
                    '}';
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        SkipNode<E> x = header.tower[0];
        while (x != null) {
            sb.append(x.value);
            x = x.tower[0];
            if (x != null)
                sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}