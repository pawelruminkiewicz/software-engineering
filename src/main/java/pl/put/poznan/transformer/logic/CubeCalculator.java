package pl.put.poznan.transformer.logic;

public class CubeCalculator implements Visitor  {
    @Override
    public void visit(Building location) {

    }

    @Override
    public void visit(Level location) {

    }

    @Override
    public void visit(Room location) {
        float z = location.getZ();
        float cube = location.getArea()*z;
        location.setCube(cube);
    }
}
