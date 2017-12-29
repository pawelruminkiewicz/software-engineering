package pl.put.poznan.transformer.logic;

public class Room extends Location implements Visitable{
    private float area;
    private float cube;
    private float heating;
    private float light;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
