package pl.put.poznan.transformer.logic;

public class Room extends Location implements Visitable{
    private float x;
    private float y;
    private float z;
    private int bulbCount;
    private float bulbPower;
    private int heaterCount;
    private float heaterPower;
    private boolean isAlerted;

    public Room(int id, String name, float x, float y, float z, int bulbCount, float bulbPower, int heaterCount,float heaterPower, Level level) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.bulbCount = bulbCount;
        this.bulbPower = bulbPower;
        this.heaterCount = heaterCount;
        this.heaterPower = heaterPower;
        level.getRooms().add(this);
        isAlerted = false;
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

    public int getHeaterCount() {
        return heaterCount;
    }

    public float getHeaterPower() {
        return heaterPower;
    }

    public boolean isAlerted() {
        return isAlerted;
    }

    public void setAlerted(boolean alerted) {
        isAlerted = alerted;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
