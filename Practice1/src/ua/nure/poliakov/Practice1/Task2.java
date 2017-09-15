package ua.nure.poliakov.Practice1;

public class Task2 {

    public static void main(String[] args) {

        Integer a = Integer.valueOf(args[0]);
        Integer b = Integer.valueOf(args[1]);

        sum(a,b);
    }

    static void sum(int a, int b) {
        int res = a + b;
        System.out.println(res);
    }
}
