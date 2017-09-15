package ua.nure.poliakov.Practice5.Task4;

import java.util.Random;

public class Task4 extends Thread {

    private int row = 4;
    private int column = 100;

    private int[][] matrix = new int[row][column];

    int[][] fillMatrix() {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 100; j++) {
                matrix[i][j] = random.nextInt(1000);
            }
        }
        return matrix;
    }

    void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    int getMax() {
        int max = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    private synchronized int getMax(int row) {
        int[][] arr = matrix;
        int max = matrix[0][0];
        for (int j = 0; j < column; j++) {
            if (arr[row][j] > max) {
                max = arr[row][j];
            }
        }

        return max;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private int thread1() {
        final int[] row = {0};
        new Thread(new Runnable() {
            @Override
            public void run() {
                row[0] = getMax(0);
            }
        }).start();

        while (row[0] == 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return row[0];
    }

    private int thread2() {
        final int[] row1 = {0};
        new Thread(new Runnable() {
            int row2 = 0;

            @Override
            public void run() {
                row1[0] = getMax(1);
            }
        }).start();
        while (row1[0] == 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return row1[0];
    }

    private int thread3() {
        final int[] row2 = {0};
        new Thread(new Runnable() {
            @Override
            public void run() {
                row2[0] = getMax(2);
            }
        }).start();
        while (row2[0] == 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return row2[0];
    }

    private int thread4() {
        final int[] row3 = {0};
        new Thread(new Runnable() {
            @Override
            public void run() {
                row3[0] = getMax(3);
            }
        }).start();
        while (row3[0] == 0) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return row3[0];
    }

    @Override
    public void run() {
        int[] arr = new int[]{thread1(), thread2(), thread3(), thread4()};
        System.out.println(getMax(arr));
    }
}