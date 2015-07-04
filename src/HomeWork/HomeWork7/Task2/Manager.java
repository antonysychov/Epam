package HomeWork.HomeWork7.Task2;

import HomeWork.HomeWork7.Task2.Builder.Builder;
import HomeWork.HomeWork7.Task2.Shape.Shape;

public class Manager {
    private Builder b;

    public Manager(Builder b) {
        this.b = b;
    }

    public void changeBuilder (Builder b){
        this.b = b;
    }

    public Shape construct() {
        b.buildShape();
        return b.getShape();
    }
}
