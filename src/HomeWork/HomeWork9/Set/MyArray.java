package HomeWork.HomeWork9.Set;

import java.util.ArrayList;
import java.util.List;

class MyArray<T extends Comparable<T>> implements Container<T> {
    List<T> con = new ArrayList<>();

    @Override
    public Container clone() {
        Container c = new MyArray();
        for (int i = 0; i < con.size(); i++) {
            c.add(con.get(i));
        }
        return c;
    }

    @Override
    public int size() {
        return con.size();
    }

    @Override
    public T get(int index) {
        return con.get(index);
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < con.size(); i++) {
            if (con.get(i).compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(T element) {
        con.add(element);
    }

}

