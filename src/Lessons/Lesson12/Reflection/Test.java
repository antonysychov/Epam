package Lessons.Lesson12.Reflection;

import java.lang.reflect.*;

class A {
    private int a;

    public void method() {
        System.out.println(a);
    }

    public void method(int a) {
        System.out.println(a);
    }

    public static void g() {
        System.out.println("static");
    }

    public A(Integer a) {
        this.a = a;
    }
}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //Способы получения объекта класса Class (их 3)
        Class c = A.class;
        Class c1 = Class.forName("Lessons.Lesson12.Reflection.A");


        A pa = new A(3);
        Class c2 = pa.getClass();

        //Способы получения объекта данного Class
        A a = (A) c1.newInstance();
        a.method();

        Field[] f = c.getFields();

        for (Field f1 : f) {
            System.out.println(f1.getType() + f1.getName());
        }

        //изменение уровня доступа и присвоение значения приватному полю

        Field field = c1.getDeclaredField("a");
        field.setAccessible(true);

        field.set(a, new Integer(1000));
        System.out.println(field.get(a));
        a.method();
        int mod = field.getModifiers();
        System.out.println(Modifier.toString(mod));

        Class[] parameterTypes = {int.class};
        Method m = c1.getDeclaredMethod("method", parameterTypes);
        Object arg[] = {new Integer(300)};
        m.invoke(a, arg);


        //----------
        //a = (A) c2.newInstance(new Integer(200));
        Class[] interfaces = c2.getInterfaces();
        Class superClass = c2.getSuperclass();
        Class[] param = {int.class};
        Constructor con = c1.getConstructor(param);
        Object[] arg1 ={};
        Method m1 = c1.getDeclaredMethod("g", parameterTypes);
        m.invoke(null, arg);

        int t = Math.abs(-5);
    }
}
