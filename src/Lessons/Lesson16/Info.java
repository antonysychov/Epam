package Lessons.Lesson16;

public class Info {
    public static void main(String[] args) {
        System.out.println(new Integer("u000a"));
        //try {
        System.out.println("ad");
    } //catch (IOException r) {} //������� ������ ���������� �.�. IO �� ��������, � IO - ��� ������ chtecked exception
    //catch (Exception e ) //- ���� �.�. ��� ��� � unchecked ����������


    //Cyclic Barrier ��� ������, ������� �������� � ������� await �������� ���� � ������� �� ���������� ���. ���������� �������, ����������� � ������������
}
interface A {
    void eat();
}

interface B extends A {
    void eat();     //��� �����
}

//�� ����������� ����������� ������
//����������� FixedThreadPool()