package ua.nure.poliakov.Practice6;

import ua.nure.poliakov.Practice6.Task7.Range;
import ua.nure.poliakov.Practice6.task1.Word;
import ua.nure.poliakov.Practice6.task2.Task2Array;
import ua.nure.poliakov.Practice6.task2.Task2Linked;
import ua.nure.poliakov.Practice6.task3.Car;
import ua.nure.poliakov.Practice6.task3.Parking;
import ua.nure.poliakov.Practice6.task4.Graph;
import ua.nure.poliakov.Practice6.task6.IO;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        Word word = new Word();
        word.print();

        System.out.println();

        long startArr = System.nanoTime();
        Task2Array task2Array = new Task2Array();
        task2Array.print();
        long finishArr = System.nanoTime();
        System.out.println(finishArr - startArr + " nano sec => ArrayList");

        System.out.println();

        long startLinked = System.nanoTime();
        Task2Linked task2Linked = new Task2Linked();
        task2Linked.print();
        long finishLinked = System.nanoTime();
        System.out.println(finishLinked - startLinked + " nano sec => LinkedList");

        System.out.println();

        Parking parking = new Parking();
        parking.fill();
        System.out.println(parking.addCarToParking(new Car("Mercedes"), 6));
        System.out.println(parking.addCarToParking(new Car("Ferrari"), 8));
        System.out.println(parking.addCarToParking(new Car("BMW"), 2));
        System.out.println(parking.addCarToParking(new Car("Ford"), 9));
        System.out.println(parking.addCarToParking(new Car("Audi"), 0));
        System.out.println(parking.removeCarFromPark(new Car("Ford"), 9));

        System.out.println();

        Graph graph = new Graph(6);
        graph.addVertex(1);
        graph.addVertex(5);
        graph.addEdge(1, 5);

        graph.addVertex(6);
        graph.addVertex(9);
        graph.addEdge(6, 9);

        graph.addVertex(3);
        graph.addVertex(7);
        graph.addEdge(3, 7);

        System.out.println(graph.getList());
        System.out.println(graph.getPair(1));
        graph.removeVertex(3);
        graph.removeVertex(7);
        System.out.println(graph.getList());
        graph.removeEdge(1, 5);
        System.out.println(graph.getList());

        System.out.println();

        IO.input("-input file1.txt frequency");
        System.out.println();
        IO.input("-input file.txt length");
        System.out.println();
        IO.input("-input file1.txt duplicate");

        System.out.println();

        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(20);
        list.add(32);
        list.add(12);
        list.add(11);
        list.add(19);
        list.add(23);
        list.add(74);

        Range range = new Range(3, 7, list, false);
        System.out.println();
        System.out.println(range.getList());
    }
}