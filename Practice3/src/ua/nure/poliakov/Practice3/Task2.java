package ua.nure.poliakov.Practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    private Until read = new Until();

    private static Set<String> getMin = new HashSet<>();
    private static Set<String> getMax = new HashSet<>();

    public void check(String input) {
        String[] arr = getText(input).toString().split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= minWord(input) && arr[i].length() <= minWord(input)) {
                getMin.add(arr[i] + " ");
            } else if (arr[i].length() >= maxWord(input) && arr[i].length() <= maxWord(input)) {
                getMax.add(arr[i] + " ");
            }
        }

        System.out.println("Min: " + getMin);
        System.out.println("Max: " + getMax);

    }

    int minWord(String input) {
        String[] arr = getText(input).toString().split(" ");
        String min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min.length() > arr[i].length()) {
                min = arr[i];
            }
        }
        return min.length();
    }

    int maxWord(String input) {
        String[] arr = getText(input).toString().split(" ");
        String max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max.length() < arr[i].length()) {
                max = arr[i];
            }
        }
        return max.length();
    }

    StringBuffer getText(String input) {
        String[] textFile = read.read(input).split("\\W+");
        Pattern pattern = Pattern.compile("\\w+");
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < textFile.length; i++) {
            String text = textFile[i];
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                result.append(matcher.group(0) + " ");
            }
        }
        return result;
    }
}