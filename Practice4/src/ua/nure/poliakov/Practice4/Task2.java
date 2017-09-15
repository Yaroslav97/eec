package ua.nure.poliakov.Practice4;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public String facade(String fileRandom, String fileSort) throws IOException {
        writeRand(fileRandom);
        writeSort(fileRandom, fileSort);
        return IO.getInput(fileSort);
    }

    private int[] getRandom() {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        return arr;
    }

    private void writeRand(String fileName) throws IOException {
        IO.getOutput(fileName, Arrays.toString(getRandom()));
    }

    private void writeSort(String read, String write) throws IOException {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(IO.getInput(read));
        StringBuilder arr = new StringBuilder();
        while (matcher.find()) {
            arr.append(matcher.group()).append(" ");
        }
        String[] str = arr.toString().split(" ");
        int[] num = new int[10];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        IO.getOutput(write, Arrays.toString(bubbleSort(num)));
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
