package Lessons.Lesson12.ClassLoaders;

public class Info {
    //����� � PermanentGeneration ������������ �� ���� ������ ���� (����-���)
}

//�/� B pa = (B)Factory.getInstance(newFile);

interface A{}

class B{
    A pa;
}

class C implements A{

}

//���� ���� B.pa -> C