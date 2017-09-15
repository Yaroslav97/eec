package ua.nure.poliakov.SummaryTask1;

import ua.nure.poliakov.SummaryTask1.toy.ball.LargeBall;
import ua.nure.poliakov.SummaryTask1.toy.ball.MediumBall;
import ua.nure.poliakov.SummaryTask1.toy.ball.SmallBall;
import ua.nure.poliakov.SummaryTask1.toy.block.LargeBlock;
import ua.nure.poliakov.SummaryTask1.toy.block.MediumBlock;
import ua.nure.poliakov.SummaryTask1.toy.block.SmallBlock;
import ua.nure.poliakov.SummaryTask1.toy.car.LargeCar;
import ua.nure.poliakov.SummaryTask1.toy.car.MediumCar;
import ua.nure.poliakov.SummaryTask1.toy.car.SmallCar;
import ua.nure.poliakov.SummaryTask1.toy.doll.LargeDoll;
import ua.nure.poliakov.SummaryTask1.toy.doll.MediumDoll;
import ua.nure.poliakov.SummaryTask1.toy.doll.SmallDoll;
import ua.nure.poliakov.SummaryTask1.toy.Toy;

import java.util.*;

public class GameRoom {

    private int maxToy;
    private double maxMoney;
    private double money;
    private List<Toy> gameRoom;
    private List<Toy> toys;

    private List<Class<? extends Toy>> list = new ArrayList<Class<? extends Toy>>(Arrays.asList(SmallBall.class, MediumBall.class,
            LargeBall.class, SmallBlock.class, MediumBlock.class, LargeBlock.class, SmallCar.class, MediumCar.class, LargeCar.class,
            SmallDoll.class, MediumDoll.class, LargeDoll.class));

    private boolean addToy(Toy toy) {
        if (gameRoom.size() < maxToy && money + toy.getPrice() <= maxMoney) {
            gameRoom.add(toy);
            return true;
        } else {
            return false;
        }
    }

    public Toy getRandomToy(List<Class<? extends Toy>> list) throws InstantiationException, IllegalAccessException {
        Random random = new Random();
        return list.get(random.nextInt(list.size())).newInstance();
    }

    private Toy getToy() throws IllegalAccessException, InstantiationException {
        return getRandomToy(list);
    }

    private String output(List<Toy> toys) {
        String result = "";
        for (Toy toy : toys) {
            result += toy.toString() + System.lineSeparator();
        }
        result += getResult(toys);
        return result;
    }

    public String output() {
        return output(gameRoom);
    }

    private String getResult(List<Toy> toys) {
        return "GameRoom{" +
                "used money: " + getTotalCost(toys) +
                ", used toys: " + toys.size() +
                ", maxToy=" + maxToy +
                ", maxMoney=" + maxMoney +
                '}';
    }

    private double getTotalCost(List<Toy> toys) {
        double result = 0;
        for (Toy toy : toys) {
            result += toy.getPrice();
        }
        return result;
    }

    public String room(int maxToys, double maxMoneys, String sortBy) throws IllegalAccessException, InstantiationException {
        this.maxToy = maxToys;
        this.maxMoney = maxMoneys;
        this.gameRoom = new ArrayList<Toy>();
        this.toys = new ArrayList<Toy>();


        fillGameRoom();

        switch (sortBy) {
            case "sortByPrice":
                sortByPrice();
                break;
            case "sortByName":
                sortByName();
                break;
            default:
                return "Incorrect sort";
        }

        return output();
    }

    private void fillGameRoom() throws InstantiationException, IllegalAccessException {
        while (true) {
            Toy toy = getToy();
            if (!addToy(toy)) {
                break;
            }
            money += toy.getPrice();
        }
    }

    private void sortByPrice() {
        Collections.sort(gameRoom, new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return ((Double) o1.getPrice()).compareTo(o2.getPrice());
            }
        });
    }

    private void sortByName() {
        Collections.sort(gameRoom, new Comparator<Toy>() {
            public int compare(Toy o1, Toy o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    public String findByPrice(double startCost, double endCost) {
        toys.clear();
        for (Toy toy : gameRoom) {
            if (toy.getPrice() >= startCost && toy.getPrice() <= endCost) {
                toys.add(toy);
            }
        }
        return output(toys);
    }
}