package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Class allows to calculate area of buildings, levels and rooms
 */
public class AreaCalculator implements Visitor {
    /**
     * Overloaded method visit for building objects
     * @param location building object
     */
    @Override
    public void visit(Building location) {
        ArrayList<Level> levels = location.getLevels();
        float area = 0;
        for(Level level:levels){
            area = area + level.getArea();
        }
        location.setArea(Float.parseFloat((String.format("%.2f",area)).replace(',','.')));
    }

    /**
     * Overloaded method visit for level objects
     * @param location level object
     */
    @Override
    public void visit(Level location) {
        ArrayList<Room> rooms = location.getRooms();
        float area = 0;
        for(Room room:rooms){
            area = area + room.getArea();
        }
        location.setArea(Float.parseFloat((String.format("%.2f",area)).replace(',','.')));
    }

    /**
     * Overloaded method visit for room objects
     * @param location room object
     */
    @Override
    public void visit(Room location) {
        float x = location.getX();
        float y = location.getY();
        float area = x*y;
        location.setArea(Float.parseFloat((String.format("%.2f",area)).replace(',','.')));
    }
}
