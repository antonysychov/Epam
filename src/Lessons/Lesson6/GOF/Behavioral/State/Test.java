package Lessons.Lesson6.GOF.Behavioral.State;

public class Test {
    public static void main(String[] args) {
        TV tv = new TV();
        tv.switchOn();
        tv.changeChannel();
        tv.switchOff();
        tv.changeChannel();
    }
}
