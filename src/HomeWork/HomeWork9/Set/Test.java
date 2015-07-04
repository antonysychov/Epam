package HomeWork.HomeWork9.Set;

public class Test {
    public static void main(String[] args) {
        Container<ImplAB> arrayAB = new MyArray<ImplAB>() {
            {
                add(new ImplAB());
                add(new ImplAB());
                //add(new ImplA()); //mistake
            }
        };
        Container<ImplA> arrayA = new MyArray<ImplA>() {
            {
                add(new ImplA());
                add(new ImplA());
                //add(new ImplB()); //mistake
            }
        };

        Set<ImplAB> setAB = new Set<ImplAB>(arrayAB);
       // Set<ImplAB> setAB1 = new Set<ImplAB>(arrayA); //Mistake

        setAB.union(setAB);
    }
}
