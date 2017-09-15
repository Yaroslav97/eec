package ua.nure.poliakov.SummaryTask1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestGameRoom {
    @Test
    public void gameRoomTest() throws InstantiationException, IllegalAccessException {
        GameRoom gameRoom = new GameRoom();
        String actual = gameRoom.room(25, 400, "sortByPrice");
        String expected = gameRoom.output();
        assertEquals(expected, actual);
    }
}