package Lessons.Lesson9.Generic;

public class Test {
    public static void main(String[] args) {
        A1 pb = new A1();
        Integer i = 10;
        Double d = 3.4;
        System.out.println(pb.method(i, d));
        System.out.println(pb.method(10, 3.4));
    }
}


class A1 {
    int a;

    public <T> boolean method(T val, T val1) {
        //когда разные аргументы то они приводяться к наиболее ближнему общему классу (B,C -> B; A,B -> Object )
        System.out.println(val instanceof Integer);
        System.out.println(val instanceof Double);
        return val.equals(val1);
    }
}

//на этапе компиляции все параметризированные типы приводятся к Object


////////////////////////

class A{

}

class B<E> {
    E value;
    public void f(E a){

    }
}

class C<T> extends B<T>{}

class Test1 {
    public static void main(String[] args) {
        C<Integer> pc = new C<>();
    }
}