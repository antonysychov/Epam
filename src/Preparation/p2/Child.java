package Preparation.p2;

class A1 {
    void say(){
        System.out.println(1);
    }
}

class A2 extends A1 {
    void say(){
        System.out.println(2);
    }
}

class A3 extends A2 {
    void say(){
        System.out.println(3);
    }
}

class Test {
    public static void main(String[] args) {
        A1 a1 = new A2();
        a1.say();
    }
}

class Parent {
     void say() {
    }
}

class Child extends Parent {
    void say() {
    }
}