package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class Building extends Location implements Visitable{
    private ArrayList<Level> levels;

    public Building(int id,String name,ArrayList<Level> levels) {
        this.levels = levels;
        this.id = id;
        this.name = name;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
