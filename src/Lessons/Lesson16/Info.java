package Lessons.Lesson16;

public class Info {
    public static void main(String[] args) {
        System.out.println(new Integer("u000a"));
        //try {
        System.out.println("ad");
    } //catch (IOException r) {} //вызовет ошибку компил€ции т.к. IO не достижим, а IO - это только chtecked exception
    //catch (Exception e ) //- норм т.к. Їто еще и unchecked исключени€


    //Cyclic Barrier все потоки, которые вызывают у баръера await засыпают пока к баръеру не обратитьс€ опр. количество потомок, указываемое в конструкторе
}
interface A {
    void eat();
}

interface B extends A {
    void eat();     //так можно
}

//дз реализовать циклический баръер
//реализовать FixedThreadPool()