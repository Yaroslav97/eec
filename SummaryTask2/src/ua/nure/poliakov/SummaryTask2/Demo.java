package ua.nure.poliakov.SummaryTask2;

import ua.nure.poliakov.SummaryTask2.sort.SortText;
import ua.nure.poliakov.SummaryTask2.text.Line;
import ua.nure.poliakov.SummaryTask2.text.Word;
import ua.nure.poliakov.SummaryTask2.io.IO;

public class Demo {

    public static final String FILE = "file.txt";

    public static final String SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {

        IO.delSpace(FILE);

        System.out.println(Line.getLine(FILE));

        System.out.println(SEPARATOR);

        System.out.println(Word.getWord(FILE));

        System.out.println(SEPARATOR);

        SortText sortWord = new SortText();

        for (Object o : sortWord.facade(FILE, "о")) {
            System.out.print(o + ", ");
        }
    }
}