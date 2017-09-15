package ua.nure.poliakov.SummaryTask3.entity;

import java.util.ArrayList;
import java.util.List;

public class Greenhouse {

    private List<Flower> greenhouses;

    public List<Flower> getGreenhouses() {
        if (greenhouses == null) {
            greenhouses = new ArrayList<Flower>();
        }
        return greenhouses;
    }

    @Override
    public String toString() {
        if (greenhouses == null || greenhouses.size() == 0) {
            return "Test contains no questions";
        }
        StringBuilder result = new StringBuilder();
        for (Flower flower : greenhouses) {
            result.append(flower).append('\n');
        }
        return result.toString();
    }
}