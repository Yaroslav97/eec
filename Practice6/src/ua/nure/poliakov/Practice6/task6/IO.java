package ua.nure.poliakov.Practice6.task6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IO {
    public static String getInput(String fileName) {
        StringBuilder text = new StringBuilder();
        try {
            Scanner reader = new Scanner(new File(fileName), "Cp1251");
            while (reader.hasNextLine()) {
                text.append(reader.nextLine()).append(System.lineSeparator());
            }
            return text.toString().trim();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        return text.toString();
    }

    public static void input(String input) {

        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        Part3 part3 = new Part3();

        Pattern pattern = Pattern.compile("(-\\w+)(\\s.+\\.txt)(\\s\\w+)");
        Matcher matcher = pattern.matcher(input);

        String query = "";
        String file = "";
        String part = "";

        if (matcher.find()) {
            query = matcher.group(1).trim();
            file = matcher.group(2).trim();
            part = matcher.group(3).trim();
        }
        switch (query) {
            case "-i":
                if (part.equals("frequency")) {
                    part1.facade(file);
                } else if (part.equals("length")) {
                    part2.facade(file);
                } else if (part.equals("duplicate")) {
                    part3.facade(file);
                } else {
                    System.out.println("wrong input data");
                }
                break;

            case "-input":
                if (part.equals("frequency")) {
                    part1.facade(file);
                } else if (part.equals("length")) {
                    part2.facade(file);
                } else if (part.equals("duplicate")) {
                    part3.facade(file);
                } else {
                    System.out.println("wrong input data ");
                }
                break;

            default:
                System.out.println("wrong command");
                break;
        }
    }
}