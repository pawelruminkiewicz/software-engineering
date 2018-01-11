package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

public class HeatingPowerCalculator implements Visitor {

    private float convert2f(float value){
        return Float.parseFloat((String.format("%.2f",value)).replace(',','.'));
    }
    @Override
    public void visit(Building location) {
        ArrayList<Level> building = location.getLevels();
        float cube = location.getCube();
        float heatSum = 0;
        float heatAvg;

        for(Level lvl: building){
            for(Room r : lvl.getRooms()){
                heatSum += r.getHeaterCount() * r.getHeaterPower();
            }
        }
        heatAvg = convert2f(heatSum/cube);
        location.setHeating(heatAvg);
    }

    @Override
    public void visit(Level location) {
        ArrayList<Room> level = location.getRooms();
        float cube = location.getCube();
        float heatSum = 0;
        float heatAvg;

        for(Room room : level){
            heatSum+= room.getHeaterCount() * room.getHeaterPower();
        }
        heatAvg = convert2f(heatSum/cube);
        location.setHeating(heatAvg);
    }

    @Override
    public void visit(Room location) {
        int heaterCount = location.getHeaterCount();
        float heaterPower = location.getHeaterPower();
        float cube = location.getCube();
        float heat;

        heat = convert2f((heaterCount * heaterPower)/cube);
        location.setHeating(heat);
    }
}
