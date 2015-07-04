package Lessons.Lesson6.GOF.Structural.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MyArray implements Component {

    List<Object> list = new ArrayList<Object>();
    @Override
    public void add(Object o) {
        list.add(o);
    }
}
interface Component {
    void add(Object o);
}
