package ua.nure.poliakov.Practice5;

public class Demo {

    public static final String SEPARATOR = System.lineSeparator();

    public static void main(String[] args) throws InterruptedException {
        ua.nure.poliakov.Practice5.Task1.Main.main(new String[]{});
        Thread.sleep(1000);
        System.out.println(SEPARATOR);
        ua.nure.poliakov.Practice5.Task2.Main.main(new String[]{});
        Thread.sleep(1000);
        System.out.println(SEPARATOR);
        ua.nure.poliakov.Practice5.Task3.Main.main(new String[]{});
        Thread.sleep(2000);
        System.out.println(SEPARATOR);
        ua.nure.poliakov.Practice5.Task4.Main.main(new String[]{});
        Thread.sleep(1000);
        System.out.println(SEPARATOR);
        ua.nure.poliakov.Practice5.Task6.Main.main(new String[]{});
    }
}