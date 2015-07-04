package Lessons.Lesson6.GOF.Structural.Decorator;

public class Decorator {
}

abstract class ElementOfArt {
    abstract public void show();
}

class Picture extends ElementOfArt {
    public void show() {
        System.out.println("picture");
    }
}

class Frame extends ElementOfArt {
    ElementOfArt a;

    public Frame(ElementOfArt a) {
        this.a = a;
    }

    public void show() {
        a.show();
        System.out.println("frame");
    }
}

class Color extends ElementOfArt {
    ElementOfArt a;

    public Color(ElementOfArt a) {
        this.a = a;
    }

    public void show() {
        a.show();
        System.out.println("color");
    }
}

class Ornament extends ElementOfArt {
    ElementOfArt a;

    public Ornament(ElementOfArt a) {
        this.a = a;
    }

    public void show() {
        a.show();
        System.out.println("ornament");
    }
}

class Test {
    public static void main(String[] args) {
        ElementOfArt picture = new Picture();
        picture.show();
        System.out.println("----------------------");
        ElementOfArt pictureInFrame = new Frame(picture);
        pictureInFrame.show();
        System.out.println("----------------------");
        ElementOfArt pictureInFrameWithColor = new Color(pictureInFrame);
        pictureInFrameWithColor.show();
        System.out.println("----------------------");
    }
}