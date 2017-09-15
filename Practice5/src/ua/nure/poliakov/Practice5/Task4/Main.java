package ua.nure.poliakov.Practice5.Task4;

public class Main {

    public static void main(String[] args) {

        Task4 task4 = new Task4();
        task4.fillMatrix();
        task4.print();

        System.out.println();

        long start = System.nanoTime();
        System.out.println("Max element => " + task4.getMax());
        long end = System.nanoTime();
        System.out.println("Time:" + (end-start) + " nano sec");

        System.out.println();


        long start1 = System.nanoTime();
        task4.start();
        long end1 = System.nanoTime();
        System.out.println("Time:" + (end1-start1) + " nano sec");

    }
}
