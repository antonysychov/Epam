package Lessons.Lesson9.Generic.LevelUP;

import java.util.LinkedList;
import java.util.List;

class D<E> {
    E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

public class A {

    public void f(D<? super A> pa) {
        A ppa = new A();
        pa.setValue(ppa);
    }

    public void f1(D<?> pa) {
        A ppa = new A();
        pa.getValue();
    }
}


class B extends A {

}

class C {
}

class Test {
    public static void main(String[] args) {
        B pb = new B();
        A pa = new A();
        C pc = new C();
        //pa.f(pc);
        //pa.f(pb);
    }
}

//super дает гарантию что, в контейнере могут лежать объекты классов с функционалом не большим чем функционал А (в случае (? super A))

interface Ai {
}

interface Bi {
}

class Ca<I extends Ai & Bi> {
}

class Aa {
}

class Bb extends Aa {
}

class Cc extends Bb {
    public static void f(List<? extends A> pa) {

    }

    public static void main(String[] args) {
        List<A> list = new LinkedList<>();
        f(list);
    }
}



