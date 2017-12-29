package pl.put.poznan.transformer.logic;

public class Room extends Location implements Visitable{
    private float area;
    private float cube;
    private float heating;
    private float light;
    private float x;
    private float y;
    private float z;
    private int bulpCount;
    private int bulpPower;

    public Room(int id,String name,float x, float y, float z,int bulpCount,int bulpPower) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.bulpCount = bulpCount;
        this.bulpPower = bulpPower;
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

    public void setArea(float area) {
        this.area = area;
    }

    public void setCube(float cube) {
        this.cube = cube;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public void setLight(float light) {
        this.light = light;
    }

    public int getBulpCount() {
        return bulpCount;
    }

    public int getBulpPower() {
        return bulpPower;
    }

    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
