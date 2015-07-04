package Lessons.Lesson14.Threads.ThreadStop;

public class MyThread extends Thread {
    @Override
    public void run() {

        //правильный способ прерывать исключения
        while (!interrupted()) {
            try {
                synchronized (this) {
                    this.wait();
                }
                System.out.println("Hello");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //метод interrupt() прекращает wait, выбрасывает исключение и сбрасывает флаг isInterrupted
                // и сбрасывает метод, чтобы while( ) увидил измененный флаг, нужно занововызвать interrupt()
            }
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); //только устанавливает флаг interrupted, метод interrupted() возвращает значение флага И СБРАСЫВАЕТ ЕГО
        //метод isInterrupted() возвращает флаг и НЕ ИЗМЕНЯЕТ ЕГО !!!
        //метод interrupt()
    }
}
