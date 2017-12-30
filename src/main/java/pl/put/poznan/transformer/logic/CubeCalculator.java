package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class CubeCalculator implements Visitor  {
    @Override
    public void visit(Building location) {

    }

    @Override
    public void visit(Level location) {
        ArrayList<Room> rooms = location.getRooms();
        float cube = 0;
        for(Room room:rooms){
            cube = cube + room.getCube();
        }
        location.setCube(cube);
    }

    @Override
    public void visit(Room location) {
        float z = location.getZ();
        float cube = location.getArea()*z;
        location.setCube(cube);
    }
}
