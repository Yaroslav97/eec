package ua.nure.poliakov.Practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static String getText(String file) {
        Pattern pattern = Pattern.compile("([A-z]+)");
        StringBuffer sb = new StringBuffer();
        Matcher matcher = pattern.matcher(IO.getInput(file).toString());
        while (matcher.find()) {
            if (matcher.group().length() > 3) {
                String result = matcher.group().toUpperCase() + " ";
                sb.append(result);
            }
            else {
                String result = matcher.group() + " ";
                sb.append(result);
            }
        }
        return sb.toString();
    }
}
