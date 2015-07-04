package Preparation.p1;

import java.util.NavigableSet;

class Parent {
    Integer a = 1;
    static Integer b = 2;
}

interface Interface {
    void method(NavigableSet<String> set) throws Exception;
}

 class Overload implements Interface {
    void method() {
    }
    public void method(NavigableSet<String> set) throws Exception {
    }
}