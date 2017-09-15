package ua.nure.poliakov.Practice4;

import org.junit.Test;
import ua.nure.poliakov.Practice4.Task2;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class TestTask2 {

    @Test
    public void Test() throws IOException {
        Task2 task2 = new Task2();
        int actual = task2.facade("file1.txt", "file2.txt").split("\\s+").length;
        int expected = 10;

        assertEquals(expected, actual);
    }
}
