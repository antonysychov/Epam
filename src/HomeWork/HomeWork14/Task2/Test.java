package HomeWork.HomeWork14.Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("<(((\\w*)|(\\W)*)|(/((\\w*)|(\\W*)))|(((\\w*)|(\\W*))/))>");
        BufferedReader br = new BufferedReader((new FileReader("src\\HomeWork\\HomeWork14\\Task2\\Test.html")));

        String s;
        while ((s = br.readLine()) != null) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println(m.group());
            }
        }

    }
}
