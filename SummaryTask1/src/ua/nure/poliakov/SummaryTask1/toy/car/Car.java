package ua.nure.poliakov.SummaryTask1.toy.car;

import ua.nure.poliakov.SummaryTask1.toy.Toy;

public abstract class Car extends Toy {
    public Car(String name) {
        super(name);
    }
    public Car(){
        this("Car");
    }
}
