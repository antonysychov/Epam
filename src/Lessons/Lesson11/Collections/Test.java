package Lessons.Lesson11.Collections;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();
        A pa = new A(100);
        map.put(pa, 30);
        System.out.println(map.get(pa));
        pa.setValue(177);
        System.out.println(map.get(pa));
    }
}
