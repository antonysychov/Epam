package Lessons.Lesson6.GOF.Behavioral.TemplateMethod;

public class Test {
    public static void main(String[] args) {
        Algorithm al = new MaxAlgorithm();
        al.findElement(new int[]{1,2});
    }

}
