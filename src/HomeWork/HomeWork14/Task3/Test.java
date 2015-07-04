package HomeWork.HomeWork14.Task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(([02468][048])|([13579][26]))00|(\\d{2}(([02468][48])|([2468][048])|([13579][26])))");
        Matcher m = p.matcher("2000");

        while (m.find()) {
            System.out.println(m.group());
        }
    }


}
