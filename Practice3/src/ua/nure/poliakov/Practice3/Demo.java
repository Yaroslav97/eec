package ua.nure.poliakov.Practice3;

import java.security.NoSuchAlgorithmException;

public class Demo {

    public static final String FILE = "file.txt";
    public static final String FILE1 = "file1.txt";
    public static final String FILE2 = "file2.txt";

    public static final String LINE = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        Task5 task5 = new Task5();

        System.out.println(LINE);

        System.out.println(task1.convert1(FILE));

        System.out.println(LINE);

        System.out.println(task1.convert2(FILE));

        System.out.println(LINE);

        task1.convert3(FILE);

        System.out.println(LINE);

        System.out.println(task1.convert4(FILE));

        System.out.println(LINE);

        task2.check(FILE1);

        System.out.println(LINE);

        task3.convert(FILE2);

        System.out.println(LINE);

        System.out.println(task4.hash("pass11", "MD5"));

        System.out.println(LINE);

        System.out.printf("%s => %d", task5.toRome(81), task5.toDecimal(task5.toRome(81)));
    }
}