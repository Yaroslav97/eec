package ua.nure.poliakov.Practice4;

import org.junit.Test;
import ua.nure.poliakov.Practice4.Task3;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class TestTask3 {
    @Test
    public void checkLine() throws IOException {
        Task3 task3 = new Task3();
        String actual = task3.output("file3.txt");
        String expected = "rt, hello, java, ";
        assertEquals(expected, actual);
    }
}