package Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Info implements Runnable {
    void go(long id) {
        System.out.println(id);
    }

    public static void main(String[] args) throws InterruptedException {
        B b = new B();
        List<String> list = new LinkedList<>();
        list.add("adawd");
        list.add("adawdd");
        list.add("adawasd");
        b.foo(list);

        Object s = pick("d", new ArrayList<String>());
    }
    static <T> T pick(T a1, T a2) { return a2; }
    public void run() {
        go(Thread.currentThread().getId());
    }
}

interface MyObjectStore<T, E extends Number> {
    /**
     * Кладёт значение в хранилище по заданному ключу.
     *
     * @param key   Ключ.
     * @param value Значение.
     */
    void put(T key, E value);

    void foo(List<?> l) ;
}

class B implements MyObjectStore<Integer, Integer> {

    @Override
    public void foo(List<?> l) {
    }

    @Override
    public void put(Integer key, Integer Integer) {

    }
}

class Car extends Vehicle {
}

class Vehicle {
}