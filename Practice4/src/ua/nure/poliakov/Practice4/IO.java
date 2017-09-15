package ua.nure.poliakov.Practice4;

import java.io.*;
import java.util.Scanner;

public class IO {
    public static String getInput(String fileName) {
        StringBuilder builder = new StringBuilder();
        try {
            File file = new File(fileName);
            Scanner read = new Scanner(file, "Cp1251");
            while (read.hasNextLine()) {
                builder.append(read.nextLine()).append(System.lineSeparator());
            }
            return builder.toString().trim();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        return builder.toString();
    }

    public static void getOutput(String fileName, String text) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.write(text);
        writer.flush();
        writer.close();
    }
}