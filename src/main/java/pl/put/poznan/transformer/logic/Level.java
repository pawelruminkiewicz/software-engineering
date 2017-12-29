package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class Level extends Location implements Visitable{
    private ArrayList<Room> rooms;

    public Level(int id,String name,ArrayList<Room> rooms) {
        this.rooms = rooms;
        this.id = id;
        this.name = name;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
