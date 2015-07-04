package HomeWork.HomeWork14.Task1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ThreadPoolExecutor {
    private final BlockingQueue<Runnable> tasks = new LinkedBlockingDeque<Runnable>();
    private List<WorkerThread> threads;
    private boolean awaitTermination;

    public ThreadPoolExecutor(int capacity) {
        this.threads = new LinkedList<WorkerThread>() {{
            for (int i = 0; i < capacity; i++) {
                WorkerThread wt = new WorkerThread();
                add(wt);
                wt.start();
            }
        }};
    }

    public void execute(Runnable task) {
        if (task == null) throw new NullPointerException();
        tasks.add(task);
        synchronized (tasks) {
            tasks.notify();
        }
    }

    public synchronized void awaitTermination() throws InterruptedException {
        awaitTermination = true;
        for (WorkerThread thread : threads) {
            if (thread.isBusy()) thread.join();
        }
    }

    public synchronized int runningTasks() {
        int count = 0;
        for (Thread thread : threads) {
            if (thread.getState() == Thread.State.RUNNABLE) {
                count++;
            }
        }
        return count;
    }

    private class WorkerThread extends Thread {
        private Runnable task;

        public void executeTask(Runnable task) {
            this.task = task;
        }

        public boolean isBusy() {
            return this.getState() == State.RUNNABLE;
        }

        @Override
        public void run() {
            while (!awaitTermination || task != null || !tasks.isEmpty()) {
                if (task == null) {
                    try {
                        synchronized (tasks) {
                            while (tasks.isEmpty()) {
                                tasks.wait();
                            }
                            task = tasks.poll();
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                } else {

                    executeCurrentTask();
                }
            }
        }

        private void executeCurrentTask() {
            task.run();
            task = null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task ¹" + finalI + " started");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task ¹" + finalI + " completed");
                }
            });
        }
        executor.awaitTermination();
        System.out.println("all threads completed ");
    }
}

