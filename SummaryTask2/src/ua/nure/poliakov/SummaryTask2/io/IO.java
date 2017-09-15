package ua.nure.poliakov.SummaryTask2.io;

import java.io.*;
import java.nio.charset.Charset;

public class IO {

    /**
     * Method for reading from files
     * @param fileName
     * Name of file
     * @return text frome file
     */
    public static String getInput(String fileName){
        String charsetName = "utf-8";
        StringBuilder builder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName),
                        Charset.forName(charsetName)))) {
            while (br.ready()){
                builder.append(br.readLine()).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return builder.toString().trim();
    }

    /**
     * Method for writing some text to file
     * @param fileName
     * Name of file
     * @param text
     * Text
     * @throws IOException
     */
    private static void getOutput(String fileName, String text){
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(fileName));

            writer.write(text);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * Method remove tabs
     * @param fileName
     * Name of file
     * @return Text without tabs
     */
    public static String delSpace(String fileName) {
        String text = getInput(fileName).trim().replaceAll("\\p{Blank}+", " ");
            getOutput(fileName, text);
        return text;
    }
}