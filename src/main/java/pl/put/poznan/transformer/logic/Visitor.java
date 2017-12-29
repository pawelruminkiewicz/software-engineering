package pl.put.poznan.transformer.logic;

public interface Visitor {
    public void visit(Building location);
    public void visit(Level location);
    public void visit(Room location);
}
