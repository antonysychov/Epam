package Lessons.Lesson17.String;

public class Info {
    //пул строк находитьс€ в JVM в Permanent Generation
    //ascii - american standard code for information interchange, занимает 8 бит
    //unicode - шире, содержит нац. алфавиты,  занимает 16, 32 бита
    //StringBuilder/StringBuffer не переопредел€ют hashCode() т.к. они mutable,
    //а изменение объекта после занесени€ его в map может привести к потере объекта
    public static void main(String[] args) {
        String s = "Hello";
        String s1 = new String("Hello");  //строка не попадает в пул
        String s2 = s1.intern();          //заносим строку в пул
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuffer.append("h");
        stringBuilder.append("h");
        System.out.println(stringBuffer.equals(new StringBuffer(stringBuffer)));
        System.out.println(stringBuilder.equals(new StringBuilder(stringBuilder)));
    }
}

