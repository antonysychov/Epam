package Lessons.Lesson3;

public class Enums {
    public static void main(String[] args) {
        MyEnum e = MyEnum.First;
        System.out.println(e.ordinal());
        System.out.println(e.toString());
        Operations o = Operations.Mul;
        System.out.println(o.op(10, 20));
        for (Operations o2 : Operations.values()) {
            System.out.println(o2.op(10, 20));
        }
    }
}

enum MyEnum {
    First(10), Second(20), Third(30);
    int a;
    static int b;

    MyEnum(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

/*enum MyEnumError{
    int a;                                  //перечисление всегда первое
    First(10), Second(20), Third(30);
    static int b;
    MyEnumError(int a) {
        this.a = a;
    }
    public int getA(){
        return a;
    }
}*/
enum Operations {
    SUM {
        public int op(int a, int b) {
            return a + b;
        }
    },
    Mul {
        public int op(int a, int b) {
            return a * b;
        }
    },
    Sub {
        public int op(int a, int b) {
            return a - b;
        }
    };

    abstract int op(int i1, int i2);
}