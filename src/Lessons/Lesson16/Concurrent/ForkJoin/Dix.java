package Lessons.Lesson16.Concurrent.ForkJoin;

import java.util.concurrent.RecursiveTask;

public class Dix extends RecursiveTask<Double> {
    double a;
    double b;
    double eps = 0.0001;

    public Dix(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double f(double x) {
        return (x - 3);
    }

    @Override
    protected Double compute() {

        if (Math.abs((b - a)) > eps) {
            double c = (a + b) / 2;
            Dix d = null;

            if (f(a) * f(c) <= 0) {
                d = new Dix(a, c);
                d.fork();
            } else {
                d = new Dix(c, b);
                d.fork();
            }
            return d.join();
        }
        return a;
    }
}

class Test {
    public static void main(String[] args) {
        Dix d = new Dix(2, 4);
        d.fork();
        d.join();
        double res = d.join();
        System.out.println(res);

    }
}
