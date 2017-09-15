package ua.nure.poliakov.Practice3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Until {

    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch (IOException ex) {
            System.out.print("IOException");
        }
        return sb.toString();
    }

    public static StringBuffer getLine(String fileName) {
        String text = read(fileName);
        String[] arr = text.trim().split(System.lineSeparator());

        StringBuffer str = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
			String res = arr[i].trim() + System.lineSeparator();
            str.append(res);
        }
        return str;
    }

    public static StringBuffer getLogin(String fileName) {
        String text = read(fileName);
        String[] arr = text.trim().split(";");
        StringBuffer login = new StringBuffer();
        for (int i = 3; i < arr.length; i++) {
            if (i % 3 == 0) {
				String res = arr[i].trim() + System.lineSeparator();
                login.append(res);
            }
        }
        return login;
    }

    public static StringBuffer getName(String fileName) {
        String text1 = read(fileName);
        String[] arr = text1.split(";");
        StringBuffer name = new StringBuffer();
        for (int i = 3; i < arr.length; i++) {
            if (i % 3 == 1) {
				String res = arr[i] + System.lineSeparator();
                name.append(res);
            }
        }
        return name;
    }

    public static StringBuffer getEmail(String fileName) {
        String text = read(fileName);
        String[] arr = text.split(";");
        StringBuffer email = new StringBuffer();
        for (int i = 3; i < arr.length; i++) {
            if (i % 3 == 2) {
				String res = arr[i] + System.lineSeparator();
                email.append(res);
            }
        }
        return email;
    }
}
