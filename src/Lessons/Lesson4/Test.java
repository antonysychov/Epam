package Lessons.Lesson4;

public class Test implements a{

    @Override
    public void method() {
        System.out.println("dawd");
    }

    public static void main(String[] args) {
        (new Test()).method();
    }
}
interface a{
    void method() throws ArrayIndexOutOfBoundsException;
}
