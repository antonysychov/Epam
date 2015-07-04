package Lessons.Lesson3;

public class Lesson3 {
    class A {
        A(int a ) {}
    }
/*    class B extends A {
        //ошибка т.к. нет конструктора по умолчанию
    }*/

    public static void main(String[] args) {
        //повторить автораспаковку, автоупаковку
        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println(i2==1000);               //авто распаковка !!!!! повторить !!!!!!
        System.out.println(i1==i2);                 //пулл чисел в диапазоне байт
        //повторить синтаксис for each для двумерных массивов
        //область видимости переменной

        for (int i = 0, j=10; i < 10; i++) {        //переменные ТОЛЬКО одного типа в блоке инициализации
        }

        lab: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j==2) continue lab;
                System.out.println("Hello");        //6 раз
            }
        }
        lab: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j==2) break lab;
                System.out.println("Hello");        //2 раза
            }
        }

        //Вирт почитать
/*        switch (*//*строки, целые, перечисления*//*) {
            case 2: break;                          //(обязательно break)
            default:                                //посмотреть когда используеться
        }*/
        //повторить Iterator

        int[] aa = {1,7,3};
        for (final int i : aa){
            System.out.println(i);                  //при указании переменной как final, переменная каждій раз создается
        }

/*        int[] aa = {1,7,3};
        int i;                                      //так нельзя
        for (i : aa){
            System.out.println(i);                  //при указании переменной как final, переменная каждій раз создается
        }

        for (int j = 0; j < 10; j++) {
            int k = 10;
        }
        for (int j = 0; j < 10; j++)
            int k = 10;                             //в теле цикла объявлять переменные только в блоках

        //повторить области памяти куча, стек, что еще ?

        //в массивах переопределяеться только метод clone, hashCode, toString - стандартные

        //Java 8 интерфейсы
        //лямбда функции

        A pa=(p)->{System.out.println("Hello");} // реализация функционального интерфейса, для сокращения написания кода
        pa.f();*/

        /*class NoName {
            public void f(p){
                System.out.println("Hello");
            }
        }*/

         //замыкание в программировании посмотреть что такое

/*        B pb = new B(); //лямбда функции
        A pa  = pb::g;
        pa.f(100);*/

        //клонирование объектов (глубокое клонируються все ссылочные переменные), неглубокое(для всех ссыллочных полей создаються клоны, т.е. создаеться полностью независимые объекты))
        //pattern prototype
        class A {

        }
        B pbb = new B();
/*        A paa = new A(pbb);
        A pal = (A)paa.clone();*/
        //нельзя возвращать ссылки на приватные объекты-поля класса геттером - нарушение инкапсуляции

        //перечисления Enumerations

        //как значения возвращаются из методов Java
    }

}
interface A {
    public  void f();
}
class B{
    public void g (int f ){
        System.out.println(f);
    }
}
/*class NoName implements A{
    B pb;
    public NoName (B pb)
    {
        this.pb = pb;
    }
    public void f (int f) {
        pb.g(f);
    }
}*/
