package pl.put.poznan.transformer.logic;

public class Room extends Location implements Visitable{
    private float x;
    private float y;
    private float z;
    private int bulbCount;
    private float bulbPower;

    public Room(int id, String name, float x, float y, float z, int bulbCount, float bulbPower) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.bulbCount = bulbCount;
        this.bulbPower = bulbPower;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public int getBulbCount() {
        return bulbCount;
    }

    public float getBulbPower() {
        return bulbPower;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
