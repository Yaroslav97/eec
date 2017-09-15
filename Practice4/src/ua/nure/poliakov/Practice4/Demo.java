package ua.nure.poliakov.Practice4;

import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static final String FILE = "file.txt";
    public static final String FILE1 = "file1.txt";
    public static final String FILE2 = "file2.txt";
    public static final String FILE3 = "file3.txt";
    public static final String FILE4 = "file4.txt";
    public static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void main(String[] args) throws IOException {

        System.out.println(IO.getInput(FILE));

        System.out.println(LINE);

        Task1 task1 = new Task1();

        System.out.println(task1.getText(FILE));

        System.out.println(LINE);

        Task2 task2 = new Task2();
        System.out.println(task2.facade(FILE1, FILE2));

        System.out.println(LINE);

        Task3 task3 = new Task3();
        System.out.println(task3.output(FILE3));

        System.out.println(LINE);

        Task4 task4 = new Task4();
        System.out.println(task4.findLine(FILE4));

        System.out.println(LINE);

        Task5 t5 = new Task5();
        Scanner scanner = new Scanner("key");
        Scanner scanner2 = new Scanner("us");
        String key = scanner.nextLine();
        String loc = scanner2.nextLine();
        switch (loc) {
            case "us":
                System.out.println(t5.local(key, "data_en_US"));
                break;
            case "ru":
                t5.local(key, "data_ru_RU");
                break;
        }
    }
}