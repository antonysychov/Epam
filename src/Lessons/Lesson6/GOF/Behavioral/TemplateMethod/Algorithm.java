package Lessons.Lesson6.GOF.Behavioral.TemplateMethod;

abstract public class Algorithm {

    public void sortMas(int[] mas){
        System.out.println("sort massive");
    }
    abstract public int findElement(int[] mas);
}
class MaxAlgorithm extends Algorithm {
    @Override
    public int findElement(int[] mas) {
        sortMas(mas);
        System.out.println("find max element");
        return mas[mas.length-1];
    }
}

class MinAlgorithm extends Algorithm {
    @Override
    public int findElement(int[] mas) {
        sortMas(mas);
        System.out.println("find min element");
        return mas[0];
    }
}

