package HomeWork.HomeWork10;


import HomeWork.HomeWork10.Exceptions.EmptyListException;
import HomeWork.HomeWork10.Exceptions.FullListException;
import HomeWork.HomeWork10.Exceptions.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(6) {
            {
                try {
                    addLast(100);
                    addLast((1));
                    addLast((1));
                    addLast((1));
                    addLast((1));
                    addLast((1));
                    removeFirst();
                    removeFirst();
                    addLast((1));
                    addLast((2));
                    System.out.println(this);
                    remove(3);
                    remove(1);
                } catch (FullListException | EmptyListException | NoSuchElementException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
