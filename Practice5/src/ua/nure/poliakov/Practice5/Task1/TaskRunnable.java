package ua.nure.poliakov.Practice5.Task1;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class TaskRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Exception Runnable");
            }
        }
    }
}
