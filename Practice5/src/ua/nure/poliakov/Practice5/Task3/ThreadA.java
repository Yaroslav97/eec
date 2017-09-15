package ua.nure.poliakov.Practice5.Task3;


public class ThreadA extends Thread {

    @Override
    public void run() {
        Counter counter = new Counter();

        while (!isInterrupted()) {
            int a = counter.getCounterA();
            int b = counter.getCounterB();
            System.out.println(a == b);

            a++;

            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(a == b);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            b++;

            System.out.println(a == b);

            if (a > 15) {
                interrupt();
            }
        }
    }
}