package Lessons.Lesson14.Threads.ThreadStop;

public class MyThread extends Thread {
    @Override
    public void run() {

        //���������� ������ ��������� ����������
        while (!interrupted()) {
            try {
                synchronized (this) {
                    this.wait();
                }
                System.out.println("Hello");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //����� interrupt() ���������� wait, ����������� ���������� � ���������� ���� isInterrupted
                // � ���������� �����, ����� while( ) ������ ���������� ����, ����� ������������� interrupt()
            }
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); //������ ������������� ���� interrupted, ����� interrupted() ���������� �������� ����� � ���������� ���
        //����� isInterrupted() ���������� ���� � �� �������� ��� !!!
        //����� interrupt()
    }
}
