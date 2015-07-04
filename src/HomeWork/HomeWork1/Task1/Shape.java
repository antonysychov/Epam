package HomeWork.HomeWork1.Task1;

public abstract class Shape {

    protected float square;

    public float add(Shape s) {
        square = this.getSquare() + s.getSquare();      //square определяеться при вызове метода add
        return square;
    }

    public abstract float getSquare();

    //в какой момент инициализировать переменные, для которых нужны вычисления ?
}
