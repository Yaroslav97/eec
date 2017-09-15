package ua.nure.poliakov.Practice4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private String fileName;
    private Scanner scanner = new Scanner("String");
    private String in = scanner.nextLine();

    public String output(String fileName) throws IOException {
        this.fileName = fileName;
        return print();
    }

    private String print() throws IOException {
        switch (in) {
            case "char":
                return checkExpression("^[A-z]$");
            case "int":
                return checkExpression("^[0-9]+$");
            case "String":
               return checkExpression("^[A-z]{2,}+[0-9]*{2,}$");
            case "double":
               return checkExpression("^[0-9]*\\.[0-9]+$");
            default:
              return "Enter correct argument";
        }
    }

    private String checkExpression(String expression) throws IOException {
        String[] s = IO.getInput(fileName).split(", ");
        StringBuffer result = new StringBuffer();
        Arrays.toString(s);
        for (String a : s) {
            if (checkLine(a, expression)) {
                result.append(a).append(", ");
            }
        }
        return result.toString();
    }

    private boolean checkLine(String string, String expression) {
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(string);
        return m.matches();
    }
}
