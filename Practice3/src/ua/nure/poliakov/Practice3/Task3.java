package ua.nure.poliakov.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Until until = new Until();

    void convert(String input) {
        Pattern pattern = Pattern.compile("(\\w+)");
        StringBuffer result = new StringBuffer();

        Matcher match = pattern.matcher(until.read(input));

        while (match.find()) {
            result.append(match.group(0).substring(0, 1).toUpperCase() +
                    (match.group(0).length() > 1 ? match.group(0).substring(1) : "") + " ");
        }

        System.out.println(result);
    }
}