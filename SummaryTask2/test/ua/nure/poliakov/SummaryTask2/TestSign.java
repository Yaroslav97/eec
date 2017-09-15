package ua.nure.poliakov.SummaryTask2;

import org.junit.Test;
import ua.nure.poliakov.SummaryTask2.text.Sign;

import static org.junit.Assert.assertEquals;

public class TestSign {
    @Test
    public void testGetSign() {
        String actual = Sign.getSign("file.txt");
        String expected = "- - , . - , , - . - . ";
        assertEquals(expected, actual);
    }
}
