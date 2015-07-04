package Lessons.Lesson6.GOF.Structural.Proxy;

public class Calculate {
    int a;
    int b;
    public Calculate (int a, int b) {
    }
    public int calculate (int a, int b){
        return a+b;
    }
}

interface Calc{
    int calculate(int a, int b);
}

class Proxy implements Calc{
    int [] masA = new int[1000];
    int size = 0;
    int [] masB = new int[1000];
    int [] res = new int[1000];
    Calculate c;
    public Proxy (int a, int b) {
        c = new Calculate (a, b );
    }
    public int calculate (int a, int b){
        for (int i = 0; i < size; i++) {
            if (masA[i] == c.a && masB[i]==c.b){
                return res[i];
            }

        }
        int r = c.calculate(a,b);
        masA[size] = c.a;
        masB[size] = c.b;
        res[size] = r;
        size++;
        return c.calculate(a,b);
    }

}

class Test {
    public static void main(String[] args) {
        Calc cc = new Proxy(10, 59);
        int res = cc.calculate(10, 59);
    }
}