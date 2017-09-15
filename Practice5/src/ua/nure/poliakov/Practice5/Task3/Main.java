package ua.nure.poliakov.Practice5.Task3;

public class Main {
    public static void main(String[] args) {

        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();
    }
}
