package ua.nure.poliakov.Practice4;

import org.junit.Test;
import ua.nure.poliakov.Practice4.Task5;

import static junit.framework.TestCase.assertEquals;

public class TestTask5 {

    @Test
    public void Test(){
        String actual = Task5.local("key","data_en_US");
        String expected = "table";
        assertEquals(expected, actual);
    }
}