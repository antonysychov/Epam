package Lessons.Lesson6.GOF.Behavioral.Visitor;

public final class Acceptor {
    int m;
    public void accept(Visitor v) {
        v.visit(this);
    }
}

interface Visitor {
    void visit(Acceptor a);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Acceptor a) {
        System.out.println("concrete visitor");
    }
}

//для расширения класса Acceptor без наследования
//Posa patterns

class Test {
    public static void main(String[] args) {
        Acceptor a = new Acceptor();
        Visitor v = new ConcreteVisitor();
        a.accept(v);
    }
}