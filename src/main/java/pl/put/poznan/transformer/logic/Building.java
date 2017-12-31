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
     * @param levels array of levels, that are in the building
     */
    public Building(int id,String name,ArrayList<Level> levels) {
        this.levels = levels;
        this.id = id;
        this.name = name;
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
