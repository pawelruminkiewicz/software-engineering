package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class LightingPowerCalculator implements Visitor {

    @Override
    public void visit(Building location) {
        ArrayList<Level> levels = location.getLevels();
        float sumOfPowers = 0;
        for(Level lvl: levels){
            for(Room r: lvl.getRooms()){
                sumOfPowers += r.getBulpCount() * r.getBulpPower();
            }
        }
        location.setLight(sumOfPowers/location.getArea());
    }

    @Override
    public void visit(Level location) {
        ArrayList <Room> rooms = location.getRooms();
        float sumOfPowers = 0;
        for(Room room: rooms){
            sumOfPowers += room.getBulpPower() * room.getBulpCount();
        }
        location.setLight(sumOfPowers/location.getArea());
    }

    @Override
    public void visit(Room location) {
        int bulpCount = location.getBulpCount();
        float area = location.getArea();
        float bulpPower = location.getBulpPower();
        location.setLight((bulpPower * bulpCount) / area);
    }
}
