package ua.nure.poliakov.Practice3;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private Until read = new Until();

    public StringBuffer convert1(String input) {
        String[] login = String.valueOf(read.getLogin(input)).split(System.lineSeparator());
        String[] email = String.valueOf(read.getEmail(input)).split(System.lineSeparator());
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < login.length; i++) {
            String res = login[i] + " => " + email[i] + System.lineSeparator();
            result.append(res);
        }
        return result;
    }


    public StringBuffer convert2(String input) {
        String[] name = String.valueOf(read.getName(input)).split(System.lineSeparator());
        String[] email = String.valueOf(read.getEmail(input)).split(System.lineSeparator());
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < name.length; i++) {
            result.append(name[i] + " (email: " + email[i] + ")" + System.lineSeparator());
        }
        return result;
    }

    public void convert3(String input) {
        Pattern pattern = Pattern.compile("(\\w+);(\\w+)(\\s+)(\\w+);(\\w+)@google.com");
        Pattern pattern1 = Pattern.compile("(\\w+);(\\w+)(\\s+)(\\w+);(\\w+)@mail.ru");

        Matcher matcher = pattern.matcher(read.read(input));
        Matcher matcher1 = pattern1.matcher(read.read(input));

        while (matcher.find()) {
            System.out.println("google.com => " + matcher.group(1));
        }

        while (matcher1.find()) {
            System.out.println("mail.ru => " + matcher1.group(1));
        }
    }

    public StringBuffer convert4(String input) {
        Pattern pattern = Pattern.compile("(\\w+);(\\w+)(\\s+)(\\w+);(\\w+).+");
        StringBuffer result = new StringBuffer();
        Matcher matcher = pattern.matcher(read.read(input));
        while (matcher.find()) {
            result.append(matcher.group(0) + " " + pass() + System.lineSeparator());
        }
        return result;
    }

    private int pass() {
        Random random = new Random();
        return random.nextInt(8999) + 1000;
    }
}