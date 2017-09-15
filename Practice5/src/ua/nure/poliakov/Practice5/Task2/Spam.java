package ua.nure.poliakov.Practice5.Task2;

import java.util.Scanner;

public class Spam extends Thread {
    private int[] arrTime;
    private String[] arrMessage;

    public Spam(int[] arrTime, String[] arrMessage) {
        this.arrTime = arrTime;
        this.arrMessage = arrMessage;
    }

    void enter() {
        if (new Scanner(System.in).nextLine().equals(System.lineSeparator())) {
            stop();
            System.out.println("Stop");
        }
    }

    public void autoEnter() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        stop();
        System.out.println("Stop");
    }

    @Override
    public void run() {
        for (int i = 0; i < arrTime.length; i++) {
            System.out.println(arrMessage[i]);
            try {
                sleep(arrTime[i]);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }
    }
}