// JTM-174 SummaryTask1

package ua.nure.poliakov.SummaryTask1;

public class Demo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        GameRoom gameRoom = new GameRoom();
        System.out.println(gameRoom.room(19, 300, "sortByPrice"));
        System.out.println();
        System.out.println(gameRoom.findByPrice(3, 40));
    }
}