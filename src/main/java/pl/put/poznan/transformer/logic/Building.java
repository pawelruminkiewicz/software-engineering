package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class Building extends Location implements Visitable{
    private ArrayList<Level> levels;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
