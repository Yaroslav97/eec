package ua.nure.poliakov.Practice5.Task6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Task6 extends Thread {

    private String fileName;

    private static final int INDEX = 21;

    public Task6(String fileName) {
        this.fileName = fileName;
    }

   private Thread thread0 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread0.setPriority(10);
            int num0 = 0;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num0 + System.lineSeparator(), i);
                    } else {
                        writeData(fileName, num0 + "", i);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    });

    private Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread1.setPriority(9);
            int num1 = 1;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num1 + System.lineSeparator(), INDEX + i);
                    } else {
                        writeData(fileName, num1 + "", INDEX + i);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    });

   private Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread2.setPriority(8);
            int num2 = 2;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num2 + System.lineSeparator(), INDEX * 2 + i);
                    } else {
                        writeData(fileName, num2 + "", INDEX * 2 + i);
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    });

  private   Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread3.setPriority(7);
            int num3 = 3;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num3 + System.lineSeparator(), INDEX * 3 + i);
                    } else {
                        writeData(fileName, num3 + "", INDEX * 3 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

  private   Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread4.setPriority(6);
            int num4 = 4;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num4 + System.lineSeparator(), INDEX * 4 + i);
                    } else {
                        writeData(fileName, num4 + "", INDEX * 4 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

  private   Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread5.setPriority(5);
            int num5 = 5;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num5 + System.lineSeparator(), INDEX * 5 + i);
                    } else {
                        writeData(fileName, num5 + "", INDEX * 5 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

    private Thread thread6 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread5.setPriority(4);
            int num6 = 6;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num6 + System.lineSeparator(), INDEX * 6 + i);
                    } else {
                        writeData(fileName, num6 + "", INDEX * 6 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

   private Thread thread7 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread5.setPriority(3);
            int num7 = 7;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num7 + System.lineSeparator(), INDEX * 7 + i);
                    } else {
                        writeData(fileName, num7 + "", INDEX * 7 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

   private Thread thread8 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread5.setPriority(2);
            int num8 = 8;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num8 + System.lineSeparator(), INDEX * 8 + i);
                    } else {
                        writeData(fileName, num8 + "", INDEX * 8 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println(e);
            }
        }
    });

   private Thread thread9 = new Thread(new Runnable() {
        @Override
        public void run() {
            thread5.setPriority(1);
            int num9 = 9;
            try {
                for (int i = 0; i < 20; i++) {
                    if (i == 19) {
                        writeData(fileName, num9 + System.lineSeparator(), INDEX * 9 + i);
                    } else {
                        writeData(fileName, num9 + "", INDEX * 9 + i);
                    }
                }
            }catch (IOException e) {
                System.out.println("IOException");
            }
        }
    });

    @Override
    public void run() {
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
    }

    static synchronized void writeData(String filePath, String data, int seek) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(seek);
        file.write(data.getBytes());
        file.close();
    }

    private static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(seek);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }
}