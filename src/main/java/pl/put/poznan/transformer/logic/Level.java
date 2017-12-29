package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class Level extends Location implements Visitable{
    private ArrayList<Room> rooms;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
