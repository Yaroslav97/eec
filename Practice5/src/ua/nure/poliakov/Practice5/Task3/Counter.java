package ua.nure.poliakov.Practice5.Task3;

public class Counter {

    private static int counterA;
    private static int counterB;

    public static int getCounterA() {
        return ++counterA;
    }

    public static int getCounterB() {
        return ++counterB;
    }
}