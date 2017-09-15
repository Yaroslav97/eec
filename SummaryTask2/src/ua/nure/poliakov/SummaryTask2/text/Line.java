package ua.nure.poliakov.SummaryTask2.text;

import ua.nure.poliakov.SummaryTask2.io.IO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Line {

    /**
     * Method displays each String from text
     * @param fileName
     * Name of file
     * @return Strings
     */
    public static String getLine(String fileName) {
        Pattern pattern = Pattern.compile("([A-z?\\p{LC}+?0-9?\\s,-]*\\.)");
        Matcher matcher = pattern.matcher(IO.getInput(fileName));

        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            buffer.append(matcher.group()).append(System.lineSeparator());
        }
        return buffer.toString();
    }
}