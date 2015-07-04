package Lessons.Lesson18.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {
    public static void main(String[] args) {
        String regex = "[\\s][a-zA-Z][\\w]*[@][a-zA-Z][\\w]*[\\.][a-zA-Z][\\w]+";  //шаблон e-mail
        String text = "bmvjvjyvhbhv a12@yiyuy.com kjkjbkkb kbkhbh@gh.wwe";


        Pattern p1 = Pattern.compile(regex); //значит что строка можнт начинаться на "а"
        // (сколько угодно символов), и заканчиваться на один "y"
        Matcher m1 = p1.matcher(text);

        int start = 0;
        while (m1.find(start)) {
            int end = m1.end();
            start = end - 1;
            System.out.println("e-mail: " + m1.group());
        }
    }

    //дз написать чистое регулярное выражение согласно стандарту (может быть один пробел между выражениями)
    //дз определить, являеться ли год высокосный (с помощью Regex)
}
