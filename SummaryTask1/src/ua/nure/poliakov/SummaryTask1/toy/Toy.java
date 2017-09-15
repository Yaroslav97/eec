package ua.nure.poliakov.SummaryTask1.toy;

import ua.nure.poliakov.SummaryTask1.price.Price;

/**
 * Abstract class for create some toys
 * @author Yaroslav Poliakov
 *  */
public abstract class Toy {
    private String name;
    private double price;

    public Toy(String name) {
        this.name = name;
        price = Price.getPrice(name);
    }

    /**
     * Method returns the name of toy.
     */
    public String getName() {
        return name;
    }

    /**
     * Method returns the price of toy.
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
