package Lessons.Lesson11.Collections.ForEach;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        for (Integer i : l) {
            if (i == 30)
                l.remove(new Integer(10));      //�����������
            // ��� l.remove(new Integer(30));
        }//�.�. � ���������� �������� (40) �������� ��� �� ������
    }
}
