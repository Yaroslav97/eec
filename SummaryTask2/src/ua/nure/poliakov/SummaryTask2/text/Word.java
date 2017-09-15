package ua.nure.poliakov.SummaryTask2.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word extends Line {
    /**
     * Method display words from text
     * @param fileName
     * Name of file
     * @return words
     */
    public static String getWord(String fileName) {
        Pattern pattern = Pattern.compile("\\p{LC}+");
        Matcher matcher = pattern.matcher(getLine(fileName));
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            buffer.append(matcher.group()).append(" ");
        }
        return buffer.toString();
    }
}