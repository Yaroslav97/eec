package ua.nure.poliakov.SummaryTask1.price;

import java.util.HashMap;
import java.util.Map;

/**
 * The class storage prices for toys
 * @author  Yaroslav Poliakov
 */

public class Price {
    private static Map<String, Double> price = new HashMap<>();

    static {
        price.put("SmallCar", 10.0);
        price.put("MediumCar", 20.0);
        price.put("LargeCar", 30.0);

        price.put("SmallBall", 5.0);
        price.put("MediumBall", 10.0);
        price.put("LargeBall", 15.0);

        price.put("SmallBlock", 3.0);
        price.put("MediumBlock", 6.0);
        price.put("LargeBlock", 12.0);

        price.put("SmallDoll", 15.0);
        price.put("MediumDoll", 25.0);
        price.put("LargeDoll", 40.0);
    }


    /**
     *
     * Method for the getting prices by name toys
     */
    public static double getPrice(String name) {
        return price.get(name);
    }
}
