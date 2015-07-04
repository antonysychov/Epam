package Lessons.Lesson16.Concurrent.Executors;

import java.util.concurrent.*;

public class Sum implements Callable<Integer> {
    int begin;
    int end;
    int result;


    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = begin; i < end; i++) {
            result += i;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Sum s1 = new Sum(0, 5000);
        Sum s2 = new Sum(5000, 10000);
        Future<Integer> f1 = service.submit(s1);
        Future<Integer> f2 = service.submit(s2);
        //service.awaitTermination(100000, TimeUnit.DAYS);
        int total = f1.get() + f2.get();
        System.out.println(total);
    }
}
