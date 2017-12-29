package pl.put.poznan.transformer.logic;

public class AreaCalculator implements Visitor {
    @Override
    public void visit(Building location) {

    }

    @Override
    public void visit(Level location) {

    }

    @Override
    public void visit(Room location) {
        float x = location.getX();
        float y = location.getY();
        float area = x*y;
        location.setArea(area);
    }
}
