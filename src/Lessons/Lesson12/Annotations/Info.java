package Lessons.Lesson12.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    int id();

    String title();
}

public class Info {
    //бывают 3 типа аннотаций (SOURCE, CLASS, RUNTIME)
    //SOURCE используеться компялятором и не попадает в байт-код
}

@MyAnnotation(id = 10, title = "aaaa")
class A {
    @MyAnnotation (id = 10, title = "aaa")
    public void g(){
        Class c = A.class;
        MyAnnotation a = (MyAnnotation)c.getAnnotation(MyAnnotation.class);
        System.out.println(a.id());
        System.out.println(a.title());
    }
}

class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        A pa = new A();
        pa.g();
        System.out.println((new A()));

        Class c = pa.getClass();
        Class[] param = {};
        Method m = c.getMethod("g", param);
        MyAnnotation a = m.getAnnotation(MyAnnotation.class);
        System.out.println(a.id());
    }
}


