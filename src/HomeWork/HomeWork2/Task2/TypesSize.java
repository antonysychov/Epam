package HomeWork.HomeWork2.Task2;

public class TypesSize {

    public static void main(String[] args) {
        System.out.println("byte size - " + byteSize());
        System.out.println("short size - " + shortSize());
        System.out.println("int size - " + intSize());
        System.out.println("long size - " + longSize());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    static int byteSize() {
        byte b = 1;
        int size = 1;
        while (b >= 0) {
            b = (byte) (b << 1);
            size++;
        }
        return size;
    }

    static int shortSize() {
        short i = 1;
        int size = 1;
        while (i >= 0) {
            i = (short) (i << 1);
            size++;
        }
        return size;
    }

    static int intSize() {
        int i = 1;
        int size = 1;
        while (i >= 0) {
            i = i << 1;
            size++;
        }
        return size;
    }

    static int longSize() {
        long i = 1;
        int size = 1;
        while (i >= 0) {
            i = i << 1;
            size++;
        }
        return size;
    }


}
