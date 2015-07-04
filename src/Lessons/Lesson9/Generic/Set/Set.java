package Lessons.Lesson9.Generic.Set;

import java.util.ArrayList;
import java.util.List;

interface Container<T extends Comparable<? super T>>
        extends Cloneable {
    public Container clone();

    public int size();

    T get(int index);

    boolean contains(T element);

    void add(T element);
}

class Set<T extends Comparable<? super T>> {
    Container<T> c;

    public Set(Container c) {
        this.c = c;
    }

    public Set<T> union(Set<? extends Comparable<? super T>> s) {
        Set<T> result = new Set<>(c.clone());
        for (int i = 0; i < s.c.size(); i++) {
            T element = (T) s.c.get(i);
            if (!result.c.contains(element)) {
                result.c.add(element);
            }
        }
        return result;

    }
}

class MyArray<T extends Comparable<? super T>> implements Container<T> {
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

class Table implements Comparable<Table> {
    int value;

    public Table(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Table o) {
        return this.value - o.value;
    }
}

class OtherTable extends Table {
    public OtherTable(int value) {
        super(value);
    }
}

class Chair implements Comparable<Chair> {
    int value;

    public Chair(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Chair o) {
        return this.value - o.value;
    }
}

class JavaApplication274 {


    public static void main(String[] args) {
        Container<Table> ct = new MyArray<>();
        ct.add(new Table(10));
        ct.add(new Table(20));
        Set<Table> s1 = new Set<>(ct);
        Container<Chair> ch = new MyArray<>();
        ch.add(new Chair(19));
        ch.add(new Chair(30));
        Set<Chair> sh = new Set<>(ch);
        //s1.union(sh);//error
        Container<OtherTable> co = new MyArray<>();
        co.add(new OtherTable(19));
        co.add(new OtherTable(30));
        Set<OtherTable> sot = new Set<>(co);
        s1.union(sot);

    }
}
