package ua.nure.poliakov.SummaryTask1.toy.ball;

import ua.nure.poliakov.SummaryTask1.toy.Toy;

public abstract class Ball extends Toy{
    public Ball(String name) {
        super(name);
    }

    public Ball(){
        this("Ball");
    }
}
