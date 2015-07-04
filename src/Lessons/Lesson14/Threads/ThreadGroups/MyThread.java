package Lessons.Lesson14.Threads.ThreadGroups;

public class MyThread implements Runnable {
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("group1");
        ThreadGroup tg2 = new ThreadGroup(tg, "group2"); //группа являеться подгруппой tg
        MyThread m = new MyThread();
        Thread t = new Thread(tg, m);
        System.out.println(t.getThreadGroup());
    }
}
