package HomeWork.HomeWork13.Task4;

public class Test {
    public static void main(String[] args) {
        SkipSet<Integer> ss = new SkipSet<>();
        ss.insert(33);
        ss.insert(46);
        ss.insert(12);
        ss.insert(879);
        ss.insert(213);
        ss.insert(46);
        System.out.println(ss.toString());
    }
}
