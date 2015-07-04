package Projects.Project1.Utils;

public class StringFormat {
    public static String fitToSpecificLength(String s, int length) {
        StringBuilder sb = new StringBuilder(s);
        int oldLength = s.length();
        for (int i = oldLength; i < length; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
