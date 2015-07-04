package Lessons.Lesson4.Inner_Classes;

import java.util.ArrayList;

public class Test {
}

//статические вложенные классы
class External {
    private int a;
    private static int b = 20;

    public void g() {
        Internal.d = 400;
    }

    static class Internal {
        int c;
        private static int d = 30;

        public void f() {
            b = 30;
            //    a=3; ошибка доступа к нестатическим полям
        }
    }

    public static void main(String[] args) {
        External.Internal a = new External.Internal();
    }
}

class MyClass extends External.Internal {

};

//нестатические вложенные классы
class External1 {
    int a = 10;
    static int b = 20;

    class Internal1 {
        //  static int t = 8;           //нельзя создавать
        int a = 100;
    }

    public void f() {
        External1.this.a = 1;
    }
}

class MyClass1 extends External1.Internal1 {         //только передать объект внешнего класса для создания объекта внутреннего класса
    public MyClass1(External1 external) {
        external.super();
    }
}

class Test1 {
    public static void main(String[] args) {
        External1 ex = new External1();
        External1.Internal1 in = ex.new Internal1();
    }
};

//inner - статический
//nested - нестатический
//local - локальный

//внутренние классы (локальные)
//static MyInterface f(){
//    class A implements MyInterface{
//        int a = 10;
//        public int ff(){
//            return a;
//        }
//    }
//    A pa = new A();
//    MyInterface paa = new MyInterface() {
//        int a = 10;
//        public int ff() {
//            return a;
//        }
//    };
//    return pa;
//}}

interface MyInterface {
    public int ff();
}

class Test2 {
    public static void main(String[] args) {
        ArrayList l = new ArrayList() {{         //double-brace, блок нестатической инициализации
            add(10);
            add(20);
        }};
    }
}

//вложенные классы в интерфейсах
interface A {
    E pe = new E();

    class E {
        int x;
    }
}

class Test3 {
    public static void main(String[] args) {
        A.pe.x = 400;
    }
}

