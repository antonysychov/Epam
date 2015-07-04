package HomeWork.HomeWork11;

public class B implements A {
    public B() {
        System.out.println("Class B (implementation of interface A)  has been injected");
    }

    @Override
    public void printSmth(){
        System.out.println("Message from B class");
    }
}
