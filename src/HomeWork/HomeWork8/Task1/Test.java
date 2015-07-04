package HomeWork.HomeWork8.Task1;

public class Test {
    public static void main(String[] args){
        String input = "3+5*(35-1)";

        PolishNotation pn = new PolishNotation();
        System.out.println(pn.transform(input));

        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(input));
    }

}
