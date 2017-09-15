package ua.nure.poliakov.Practice4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 implements Iterable {

    private static List<String> list;

    public static String findLine(String fileName) {
        String arr = IO.getInput(fileName);
        Pattern pattern = Pattern.compile("([A-Z][a-z\\s,]*\\.)");
        Matcher matcher = pattern.matcher(arr);
        list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.toString();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
