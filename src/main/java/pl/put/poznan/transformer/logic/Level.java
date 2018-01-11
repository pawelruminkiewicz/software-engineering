package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Class represents structure of the level
 */
public class Level extends Location implements Visitable{
    private ArrayList<Room> rooms;

    /**
     * Constructor of the class
     * @param id id of the level
     * @param name name of the level
     * @param building building where the level is
     */
    public Level(int id, String name, Building building) {
        this.id = id;
        this.name = name;
        building.getLevels().add(this);
        rooms = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
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
