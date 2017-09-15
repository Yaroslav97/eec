package ua.nure.poliakov.Practice1;

public class Task3 {

    public static void main(String[] args) {

        Integer a = Integer.valueOf(args[0]);
        Integer b = Integer.valueOf(args[1]);

        System.out.println(nod(a, b));
    }

    static int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        int x = a % b;
        return nod(b, x);
    }
}
