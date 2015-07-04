package Lessons.Lesson6.GOF.Creational.FactoryMethod;

public class Product {
    int a;
    int b;
    int c;
    public Product(){}
    public void calculate(){
        c = a + b;
    }
}
class Creator {
    Product createProduct(){
        Product p = new Product();
        p.calculate();
        return p;
    }
}

//когда нежелательно напрямую вызывать конструктор