package ua.nure.poliakov.SummaryTask3.sort;

import ua.nure.poliakov.SummaryTask3.entity.Flower;
import ua.nure.poliakov.SummaryTask3.entity.Greenhouse;

import java.util.Collections;
import java.util.Comparator;

public class Sort {

    private static final Comparator<Flower> SORT_BY_NAME = new Comparator<Flower>() {
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private static final Comparator<Flower> SORT_BY_COUNTRY = new Comparator<Flower>() {
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getOrigin().compareTo(o2.getOrigin());
        }
    };

    private static final Comparator<Flower> SORT_BY_SOLID = new Comparator<Flower>() {
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getSoil().compareTo(o2.getSoil());
        }
    };

    public static void sortByFlowerName(Greenhouse greenhouse) {
        Collections.sort(greenhouse.getGreenhouses(), SORT_BY_NAME);
    }

    public static void sortBySolid(Greenhouse greenhouse) {
        Collections.sort(greenhouse.getGreenhouses(), SORT_BY_SOLID);
    }

    public static void sortByCountry(Greenhouse greenhouse) {
        Collections.sort(greenhouse.getGreenhouses(), SORT_BY_COUNTRY);
    }
}