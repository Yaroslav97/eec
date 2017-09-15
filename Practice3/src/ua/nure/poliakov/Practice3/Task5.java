package ua.nure.poliakov.Practice3;

public class Task5 {

    public static String toRome(int digit) {
        int n = digit;
        String[] arr = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
        int[] b = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100};
        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (n >= b[i]) {
                builder.append(arr[i]);
                n -= b[i];
            }
        }
        return builder.toString();
    }

    public int toDecimal(String digit) {
        String[] romeNum = {"C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        int[] decimal = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuffer romeNumber = new StringBuffer(digit);
        int arabNumber = 0;
        int i = 0;

        while (true) {
            do {
                if (romeNum[i].length() <= romeNumber.length()) {
                    if (romeNum[i].equals(romeNumber.substring(0,
                            romeNum[i].length()))) {
                        arabNumber += decimal[i];
                        romeNumber.delete(0, romeNum[i].length());
                        if (romeNumber.length() == 0){
                            return arabNumber;
						}
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } while (romeNumber.length() != 0);
            i++;
        }
    }
}
