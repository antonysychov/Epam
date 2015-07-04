package Lessons.Lesson13.Threads;

public class Sum extends Thread {
    int begin;
    int end;
    int result;
    volatile boolean flag = false;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Sum(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            result += i;
        }
        flag = true;
    }

    public int getResult() {
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        Sum s1 = new Sum(1, 5000);
        Sum s2 = new Sum(5000, 10001);
        s1.start();
        s2.start();
        //s2.join();
        //s1.join();
        while (true) {
            if (s1.flag) {
                s1.flag = false;
                System.out.println("s1" + System.currentTimeMillis());
            }
            if (s2.flag) {
                s2.flag = false;
                System.out.println("s2" + System.currentTimeMillis());
            }
        }
        //int res = s1.getResult() + s2.getResult();
        //System.out.println(res);
    }
}
