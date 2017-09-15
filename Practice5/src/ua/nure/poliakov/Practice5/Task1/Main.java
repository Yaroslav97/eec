package ua.nure.poliakov.Practice5.Task1;

public class Main {
    public static void main(String[] args) {

        TaskThread thread = new TaskThread();
        thread.start();

        TaskRunnable runnable = new TaskRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.setName("Runnable");
        thread1.start();
    }
}
