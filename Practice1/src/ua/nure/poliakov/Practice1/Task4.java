package ua.nure.poliakov.Practice1;

public class Task4 {

    public static void main(String[] args) {

        Integer a = Integer.valueOf(args[0]);

        System.out.println(sum(a));
    }

    static int sum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }
}
