package ua.nure.poliakov.Practice2;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {
        MyListImpl con = new MyListImpl();
        con.add("A");
        con.add("B");
        con.add(433);
        con.add(888);
        con.add(null);

        MyListImpl con1 = new MyListImpl();
        con1.add("A");
        con1.add("B");
        con1.add(433);
        con1.add(888);

        System.out.println(con.toString());
        System.out.println(con1.toString());

        System.out.println(con.contains("A"));

        System.out.println(con.containsAll(con1));

        System.out.println();
        System.out.println(con.remove("A"));

        System.out.println(con);


        for (Object o : con) {
            System.out.println(o);
        }

        Iterator<Object> it = con.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();


        System.out.println("----------------------------------");

        ListIterator listIterator = con1.listIterator();
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        listIterator.set("java");

        for (Object o : con1) {
            System.out.println(o);
        }
    }
}