package HomeWork.HomeWork2.Task4;

public class CheckSum {
    public static void main(String[] args) {
        float directOrder = 1f + 1f / 9 + 1f / 99 / +1f / 999 + 1f / 9999 + 1f / 99999 + 1f / 999999 + 1f / 9999999 + 1f / 99999999;
        float reverseOrder = 1f / 99999999 + 1f / 9999999 + 1f / 999999 + 1f / 99999 + 1f / 9999 + 1f / 999 + 1f / 99 + 1f / 9 + 1;

        System.out.println(directOrder);
        System.out.println(reverseOrder);
    }
}