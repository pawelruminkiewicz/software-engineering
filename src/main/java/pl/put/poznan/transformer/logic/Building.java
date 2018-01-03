package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Class represents structure of the building
 */
public class Building extends Location implements Visitable{
    private ArrayList<Level> levels;

    /**
     * Constructor of the class
     * @param id id of the building
     * @param name name of the building
     */
    public Building(int id,String name) {
        this.id = id;
        this.name = name;
        levels = new ArrayList<>();
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    /**
     * Method accept for Visitor pattern
     * @param visitor visitor of the object
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
