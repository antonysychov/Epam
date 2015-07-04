package Lessons.Lesson20.Serialiation;

import java.io.*;

public class A {
    public int a;
}

class B extends A implements Serializable {
    public int b;
}

class C extends B {
    public int c;
}

class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        C pc = new C();
        pc.a = 10;
        pc.b = 20;
        pc.c = 30;
        FileOutputStream fos = new FileOutputStream(("Temp.out"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(pc);
        FileInputStream fis = new FileInputStream(("Temp.out"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        C pc1 = (C) ois.readObject();
        System.out.println(pc1.c);
        System.out.println(pc1.b);
        System.out.println(pc1.a);
    }
}