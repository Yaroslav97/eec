package ua.nure.poliakov.Practice1;

public class Task5 {

    public static void main(String[] args) {
        facade(1, "A");
        facade(2, "B");
        facade(26, "Z");
        facade(27, "AA");
        facade(52, "AZ");
        facade(53, "BA");
        facade(702, "ZZ");
        facade(703, "AAA");

        facade("AZ", "AZ");
        facade("BA", "BA");
        facade("BB", "BB");
    }

    public static int char2digits(String number) {
        int num = 0;

        for (int i = 0; i < number.length(); i++) {
            num += (int) (number.charAt(i) - 64) * Math.pow(26, (number.length() - i) - 1);
        }
        return num;
    }

    public static String digit2chars(int number) {
        String result = "";
        String num = "";

        while (number > 0) {
            number = number - 1;
            num += (char) (number % 26 + 65);
            number = number / 26;
        }

        for (int i = num.length() - 1; i >= 0; i--) {
            result += num.charAt(i);
        }

        return result;
    }

    public static String rightColumn(String number) {
        String result = "";
        int num = char2digits(number);
        result += digit2chars(num + 1);
        return result;
    }

    static void facade(int a, String b) {
        System.out.println(digit2chars(a) + " ==> " + char2digits(b));
    }

    static void facade(String a, String b) {
        System.out.println(a + " ==> " + rightColumn(b));
    }
}