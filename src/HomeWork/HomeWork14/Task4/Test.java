package HomeWork.HomeWork14.Task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("a?\\s*b?\\s*c?\\s*d?\\s*e?\\s*f?\\s*" +
                "g?\\s*h?\\s*i?\\s*j?\\s*k?\\s*l?\\s*m?\\s*n?\\s*o?\\s*p?\\s*q?\\s*r?\\s*s?\\s*t?\\s*u?\\s*v?\\s*w?\\s*x?\\s*y?\\s*z?\\s*");
        Matcher m = p.matcher("abcdefwghijk");

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
