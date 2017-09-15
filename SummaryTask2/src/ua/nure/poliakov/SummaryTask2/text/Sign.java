package ua.nure.poliakov.SummaryTask2.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign extends Line {

    /**
     * Method display signs from text
     * @param fileName
     * Name of file
     * @return signs
     */
    public static String getSign(String fileName) {
        Pattern pattern = Pattern.compile("(\\p{Punct})");
        Matcher matcher = pattern.matcher(getLine(fileName).replaceAll("\\p{Blank}+", ""));
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            buffer.append(matcher.group()).append(" ");
        }
        return buffer.toString();
    }
}