package ua.nure.poliakov.Practice4;

import org.junit.Test;
import ua.nure.poliakov.Practice4.Task4;

import static junit.framework.TestCase.assertEquals;

public class TestTask4 {

    @Test
    public void findLineTest(){
        String actual = Task4.findLine("file4.txt");
        String expected = "[Hello, java., Hello, world.]";
        assertEquals(expected, actual);
    }
}
