package ua.nure.poliakov.Practice5.Task2;


public class Main {

    public static void main(String[] args) {
        Spam spam = new Spam(new int[]{500, 1000, 1500, 1500, 2000, 2000, 2000},
                new String[]{"Hello", "Message1", "Message2", "Message3", "Message4", "Message5", "Message6",});
        spam.start();
        spam.autoEnter();
    }
}
