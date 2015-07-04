package Lessons.Lesson4.Pereda4a_parametrov;

public class Test {

    static void swap (int a, int b){
        int temp = a;
        a=b;
        b=temp;
        System.out.println(a);
    }
    //��� �������� 2 ����� ��� if
    //������� ������������� ���� �� ����� ����������� ���������� ���������� ������, ������� ���� ����� � ����

   // static void f (int[] d){}        //����������
   //           |
    static void f (int ...d){}       //d - ������, ���� � ����� ��� ����������, ����� ���������� ���������
                                    // ������� � ���������� ����� ������� ���������

    public static void main(String[] args) {
        swap(1,2);
    }
}

class TestStatic{
    static int a = TestStatic.b;
    static int b = 3;

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
    }
}
class First {

}
class Second extends First{

}
class Third extends Second{

}
class Test1{
    static void f(First o){
        System.out.println("First");}
    static void f(Second o){
        System.out.println("Second");}

    public static void main(String[] args) {
        First ff= new Second();
        f(ff);
        f(null);
        Third ff1= new Third();
        f(ff1);
    }
}
