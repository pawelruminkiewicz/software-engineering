package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class Level extends Location implements Visitable{
    private ArrayList<Room> rooms;

    public Level(int id, String name, Building building) {
        this.id = id;
        this.name = name;
        building.getLevels().add(this);
        rooms = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
