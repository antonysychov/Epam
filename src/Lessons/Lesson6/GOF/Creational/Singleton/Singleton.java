package Lessons.Lesson6.GOF.Creational.Singleton;

 class Singleton1 {                                    //bad for multithreading
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) instance = new Singleton1();
        return instance;
    }
}

 class Singleton2 {                                    //bad for multithreading
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}



