package Lessons.Lesson10.Exceptions;

public class Info {
    //если мы знаем как конкретно можно обработать исключения то обрабатываем его в try catch
    //а не передаем вызывающему методу

    //свои исключения имеет смысл наследовать только от Exception

    //если не получаеться обработать исключение в catch блоке, то можно можно повторно пробросить исключение
    //в catch блоке

    //Exception(String message, Throwable cause)

    public static void main(String[] args) {
        try (MyClass m = new MyClass()) {
            m.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception {
}

class A {
    public void f() throws Exception1, Exception2 {
    }
}

class B extends A {
    public void f() throws Exception1 {
    }
} //можем бросать только либо
// unchecked либо исключения в методе класса - родителя

class Test {
    static A g() {
        return new B();
    }

    public static void main(String[] args) {
        A pa = g();
        try {
            pa.f();
        } catch (Exception1 e) {
        }
    }
}

//т.е. try catch блоки могут перехватывать только исключения, объявленные в классе родителе
//и в наследниках нельзя делать новые исключения т.к. в catch обрабатываються гарантированно только исключение базового класса,
//базовому классу не известно о исключениях, бросаемых наследниками
//наследник не может расширять спектр исключений, может только сужать
//в статических блоках классов можно только бросать RunTimeException, либо checked с обработкой на месте

