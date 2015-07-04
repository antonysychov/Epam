package Lessons.Lesson11.Collections;

public class A {
    int value;

    public A(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        return value == a.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

