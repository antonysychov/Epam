package Practice;

public class Test {
    protected int it = 0;
    public int i;
    public static Integer in = 3;

    public static void main(String[] args) {
        byte b = 127;
        b += 129;

        class Local {
            {
                class A{}
                System.out.println();
            }
        }
        // b = b + 129; так нельзя
    }

    class a {
        static final int a = 8;

    }
}

class Child extends Test {
    protected int it = 4;
    public int  i = 5;
}

class T {
    public static void main(String[] args) {
        Test test = new Test();
        Test child = new Child();
        System.out.println(test.it);
        System.out.println(child.it);
    }
}