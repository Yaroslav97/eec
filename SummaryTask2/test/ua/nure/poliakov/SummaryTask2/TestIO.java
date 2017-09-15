package ua.nure.poliakov.SummaryTask2;

import org.junit.Test;
import ua.nure.poliakov.SummaryTask2.io.IO;

import static org.junit.Assert.assertEquals;

public class TestIO {
    @Test
    public void testDelSpace() {
        String actual = IO.delSpace("file.txt");
        String expected = IO.delSpace("file.txt");

        assertEquals(expected, actual);
    }
}