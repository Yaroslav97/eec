package ua.nure.poliakov.SummaryTask1.toy.doll;

import ua.nure.poliakov.SummaryTask1.toy.Toy;

public abstract class Doll extends Toy{
    public Doll(String name) {
        super(name);
    }
    public Doll(){
        this("Doll");
    }
}
