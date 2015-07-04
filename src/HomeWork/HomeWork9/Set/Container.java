package HomeWork.HomeWork9.Set;

public interface Container<T extends Comparable<T>> {

    Container clone();

    int size();

    void add(T element);

    T get(int index);

    boolean contains(T element);
}

