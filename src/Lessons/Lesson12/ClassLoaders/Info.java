package Lessons.Lesson12.ClassLoaders;

public class Info {
    //класс в PermanentGeneration представляет из себя массив байт (байт-код)
}

//Д/З B pa = (B)Factory.getInstance(newFile);

interface A{}

class B{
    A pa;
}

class C implements A{

}

//конф файл B.pa -> C