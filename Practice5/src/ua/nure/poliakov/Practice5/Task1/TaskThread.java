package ua.nure.poliakov.Practice5.Task1;

public class TaskThread extends Thread{
    @Override
    public void run() {
        setName("TaskThread");
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Exception Thread");
            }
        }
    }
}
