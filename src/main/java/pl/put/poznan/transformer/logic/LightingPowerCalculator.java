package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class LightingPowerCalculator implements Visitor {

    @Override
    public void visit(Building location) {
        float light;
        ArrayList<Level> levels = location.getLevels();
        float sumOfPowers = 0;
        for(Level lvl: levels){
            for(Room r: lvl.getRooms()){
                sumOfPowers += r.getBulbCount() * r.getBulbPower();
            }
        }
        light = (sumOfPowers/location.getArea());
        location.setLight(Float.parseFloat((String.format("%.2f",light)).replace(',','.')));
    }
    @Override
    public void visit(Level location) {
        float light;
        ArrayList <Room> rooms = location.getRooms();
        float sumOfPowers = 0;
        for(Room room: rooms){
            sumOfPowers += room.getBulbPower() * room.getBulbCount();
        }
        light = sumOfPowers/location.getArea();
        location.setLight(Float.parseFloat((String.format("%.2f",light)).replace(',','.')));
    }

    @Override
    public void visit(Room location) {
        float light;
        int bulbCount = location.getBulbCount();
        float area = location.getArea();
        float bulbPower = location.getBulbPower();
        light = (bulbPower * bulbCount) / area;
        location.setLight(Float.parseFloat((String.format("%.2f",light)).replace(',','.')));
    }
}
