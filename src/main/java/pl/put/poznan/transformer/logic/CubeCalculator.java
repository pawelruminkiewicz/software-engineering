package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Class allows to calculate cube of buildings, levels and rooms
 */
public class CubeCalculator implements Visitor  {

    /**
     * Overloaded method visit for building objects
     * @param location building object
     */
    @Override
    public void visit(Building location) {
        ArrayList<Level> levels = location.getLevels();
        float cube = 0;
        for(Level level:levels){
            cube = cube + level.getCube();
        }
        location.setCube(Float.parseFloat((String.format("%.2f",cube)).replace(',','.')));
    }

    /**
     * Overloaded method visit for level objects
     * @param location level object
     */
    @Override
    public void visit(Level location) {
        ArrayList<Room> rooms = location.getRooms();
        float cube = 0;
        for(Room room:rooms){
            cube = cube + room.getCube();
        }
        location.setCube(Float.parseFloat((String.format("%.2f",cube)).replace(',','.')));
    }

    /**
     * Overloaded method visit for room objects
     * @param location room object
     */
    @Override
    public void visit(Room location) {
        float x = location.getX();
        float y = location.getY();
        float z = location.getZ();
        float cube = x*y*z;
        location.setCube(Float.parseFloat((String.format("%.2f",cube)).replace(',','.')));
    }
}
