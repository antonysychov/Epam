package HomeWork.HomeWork12.Task1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Sum {
    private int threadsCount;
    private int begin;
    private int end;
    private int result;

    public Sum(int threadsCount, int begin, int end) {
        this.threadsCount = threadsCount;
        this.begin = begin;
        this.end = end;
    }

    public int calculate() {
        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        List<Future> futures = new LinkedList<>();
        for (int i = 0; i < threadsCount; i++) {
            futures.add(service.submit(new CountingThread(threadsCount, end, begin, i)));
        }
        service.shutdown();
        try {
            service.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
            for (int i = 0; i < futures.size(); i++) {
                try {
                    result += (int) futures.get(i).get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static class CountingThread implements Callable<Integer> {
        private int threadsCount;
        private int offset;
        private int result;
        private int begin;
        private int end;

        public CountingThread(int threadsCount, int end, int begin, int offset) {
            this.threadsCount = threadsCount;
            this.end = end;
            this.begin = begin;
            this.offset = offset;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(String.format("Thread ¹ %d has started", offset));
            for (int i = begin + offset; i <= end; i += threadsCount) {
                result += i;
            }
            return result;
        }

        public int getResult() {
            return result;
        }
    }
}
