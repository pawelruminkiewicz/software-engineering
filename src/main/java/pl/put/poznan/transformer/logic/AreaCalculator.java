package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class AreaCalculator implements Visitor {
    @Override
    public void visit(Building location) {

    }

    @Override
    public void visit(Level location) {
        ArrayList<Room> rooms = location.getRooms();
        float area = 0;
        for(Room room:rooms){
            area = area + room.getArea();
        }
        location.setArea(area);
    }

    @Override
    public void visit(Room location) {
        float x = location.getX();
        float y = location.getY();
        float area = x*y;
        location.setArea(area);
    }
}
