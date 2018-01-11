package pl.put.poznan.transformer.logic;

public abstract class Location {
    int id;
    String name;
    float area;
    float cube;
    float heating;
    float light;

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

    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getLight() {
        return light;
    }

    public String getName() {
        return name;
    }

    public float getHeating() { return heating; }

    public int getId() {
        return id;
    }
}
