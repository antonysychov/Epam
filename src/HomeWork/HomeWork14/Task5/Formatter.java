package HomeWork.HomeWork14.Task5;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter {
    public static String format(String s) {
        Pattern spacesPattern = Pattern.compile("(\\s{2,})|(\\t+)");
        Pattern sentencePattern = Pattern.compile("\\s+[^.!?]*[.!?]");

        Matcher m = spacesPattern.matcher(s);
        String s1 = m.replaceAll(" ");

        List<Integer> sentencesEnds = new LinkedList<>();
        Matcher m2 = sentencePattern.matcher(s1);

        while (m2.find()) {
            sentencesEnds.add(m2.end());
        }

        StringBuilder sb = new StringBuilder(s1);
        int k = 0;
        for (Integer i : sentencesEnds) {
            sb.insert(i + k++, " ");

        }
        return sb.toString();
    }
}
