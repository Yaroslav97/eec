package ua.nure.poliakov.SummaryTask2;

import org.junit.Test;
import ua.nure.poliakov.SummaryTask2.sort.SortText;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSortText {
    @Test
    public void testFacade() {
        SortText sortText = new SortText();
        List<String> actual = sortText.facade("file.txt", "о");

        String[] expected = ("официального, компьютерной, объектно, обычно, ориентированный, помощью, " +
                "поэтому, приобретенной, программирования, строго, виртуальной, года, код, " +
                "компанией, любой, могут, они, последующем, приложениях, работать, разработанный, " +
                "типизированный, ").split(", ");

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected[i], actual.get(i));
        }
    }
}