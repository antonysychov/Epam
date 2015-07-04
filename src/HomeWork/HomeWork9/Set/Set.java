package HomeWork.HomeWork9.Set;

public class Set<T extends Comparable<T> & A & B> {
    Container<T> container;

    public Set(Container<T> container) {
        this.container = container;
    }

    public Set<T> union(Set<? extends T> set){
        Set<T> result = new Set<>(container.clone());
        for (int i = 0; i < set.container.size(); i++) {
            T element = (T) set.container.get(i);
            if (!result.container.contains(element)) {
                result.container.add(element);
            }
        }
        return result;

    }
    }

