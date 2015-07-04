package Lessons.Lesson17.String;

public class Info {
    //��� ����� ���������� � JVM � Permanent Generation
    //ascii - american standard code for information interchange, �������� 8 ���
    //unicode - ����, �������� ���. ��������,  �������� 16, 32 ����
    //StringBuilder/StringBuffer �� �������������� hashCode() �.�. ��� mutable,
    //� ��������� ������� ����� ��������� ��� � map ����� �������� � ������ �������
    public static void main(String[] args) {
        String s = "Hello";
        String s1 = new String("Hello");  //������ �� �������� � ���
        String s2 = s1.intern();          //������� ������ � ���
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuffer.append("h");
        stringBuilder.append("h");
        System.out.println(stringBuffer.equals(new StringBuffer(stringBuffer)));
        System.out.println(stringBuilder.equals(new StringBuilder(stringBuilder)));
    }
}

