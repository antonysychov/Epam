package Lessons.Lesson10.Exceptions;

public class Info {
    //���� �� ����� ��� ��������� ����� ���������� ���������� �� ������������ ��� � try catch
    //� �� �������� ����������� ������

    //���� ���������� ����� ����� ����������� ������ �� Exception

    //���� �� ����������� ���������� ���������� � catch �����, �� ����� ����� �������� ���������� ����������
    //� catch �����

    //Exception(String message, Throwable cause)

    public static void main(String[] args) {
        try (MyClass m = new MyClass()) {
            m.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception {
}

class A {
    public void f() throws Exception1, Exception2 {
    }
}

class B extends A {
    public void f() throws Exception1 {
    }
} //����� ������� ������ ����
// unchecked ���� ���������� � ������ ������ - ��������

class Test {
    static A g() {
        return new B();
    }

    public static void main(String[] args) {
        A pa = g();
        try {
            pa.f();
        } catch (Exception1 e) {
        }
    }
}

//�.�. try catch ����� ����� ������������� ������ ����������, ����������� � ������ ��������
//� � ����������� ������ ������ ����� ���������� �.�. � catch ��������������� �������������� ������ ���������� �������� ������,
//�������� ������ �� �������� � �����������, ��������� ������������
//��������� �� ����� ��������� ������ ����������, ����� ������ ������
//� ����������� ������ ������� ����� ������ ������� RunTimeException, ���� checked � ���������� �� �����

