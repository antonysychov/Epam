package HomeWork.HomeWork14.Task5;

public class Test {
    public static void main(String[] args) {
        String formatted = Formatter.format(" It is possible for a class to inherit more    than one field with the same name.     Such a " +
                "situation                  does not in itself cause          a compile-time error. However,      any attempt within " +
                "the body of the class    to refer to any such     field by its simple name will result in a " +
                "compile-time error, because         such a reference is ambiguous.");

        System.out.println(formatted);
    }
}
