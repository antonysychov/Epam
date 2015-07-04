package HomeWork.HomeWork2.Task3;

public class SetBits {
    public static void main(String[] args) {
        int test = setBits(8, 32, true);
        System.out.println(test);
    }

    static public int setBits(int a, int pos, boolean flag) {
        int mask = 1;
        for (int i = 0; i < pos; i++) {
            mask = mask >> pos;
        }
        return a | mask;
    }
}
