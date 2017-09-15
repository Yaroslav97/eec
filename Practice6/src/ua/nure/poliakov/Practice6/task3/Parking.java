package ua.nure.poliakov.Practice6.task3;

import java.util.Arrays;
import java.util.List;

public class Parking {
    private String[] parking = new String[10];

    public void fill() {
        for (int i = 0; i < parking.length; i++) {
            parking[i] = "[]";
        }
    }

    public List<String> addCarToParking(Car car, int place) {
        for (int i = place; i < parking.length; i++) {
            if (parking[place].equals("[]")) {
                parking[i] = car.getMark();
            }
        }
        return Arrays.asList(parking);
    }

    public List<String> removeCarFromPark(Car car, int place) {
        if (car.getMark().equals(parking[place])) {
            parking[place] = "[]";
        }
        return Arrays.asList(parking);
    }
}