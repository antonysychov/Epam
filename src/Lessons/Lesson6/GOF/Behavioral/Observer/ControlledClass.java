package Lessons.Lesson6.GOF.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class ControlledClass {
    int value;
    List<ControllingClass> list = new ArrayList<>();

    public void setValue(int value) {
        this.value = value;
        for (ControllingClass c : list) {
            c.note(value);
        }
    }

    public void addControlClass(ControllingClass c) {
        list.add(c);
    }

    public void removeControlClass(ControllingClass c) {
        list.remove(c);
    }
}

interface ControllingClass {
    void note(int value);
}

class ImplControlClass implements ControllingClass {
    public void note(int value) {
        System.out.println("we have changes " + value);
    }
}

class Test {
    public static void main(String[] args) {
        ControlledClass c = new ControlledClass();
        ControllingClass d = new ImplControlClass();
        ControllingClass d1 = new ImplControlClass();
        c.addControlClass(d);
        c.addControlClass(d1);
        c.setValue(100);
    }
}