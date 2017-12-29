package pl.put.poznan.transformer.logic;

public class LightingPowerCalculator implements Visitor {

    @Override
    public void visit(Building location) {

    }

    @Override
    public void visit(Level location) {

    }

    @Override
    public void visit(Room location) {
        int bulpCount = location.getBulpCount();
        float area = location.getArea();
        float bulpPower = location.getBulpPower();
        location.setLight((bulpPower * bulpCount) / area);
    }
}
