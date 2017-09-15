package ua.nure.poliakov.Practice4;

import org.junit.Test;
import ua.nure.poliakov.Practice4.Task1;

import static junit.framework.TestCase.assertEquals;

public class TestTask1 {
    @Test//(expected = Exception.class)
    public void getTextTest(){
        Task1 task1 = new Task1();
        String actual = task1.getText("file.txt");
        String expected = "WHEN I was YOUNGER so MUCH YOUNGER THAN TODAY" +
                " I NEVER NEEDED ANYBODY s HELP in any way " +
                "But now THESE DAYS are GONE I m not so SELF ASSURED " +
                "Now I FIND I ve CHANGED my MIND I ve OPENED up the DOORS ";
        assertEquals(expected, actual);
    }
}
