package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class RoomTest {
    private AreaCalculator areaCalculator;
    private CubeCalculator cubeCalculator;
    private Room room11;
    private Room room12;
    private Room room21;
    private Room room22;
    private Level level1;
    private Level level2;
    private Building building;

    @Before
    public void setUp() throws Exception {
        areaCalculator = new AreaCalculator();
        cubeCalculator = new CubeCalculator();

        building = new Building(1, "Gazownia",3);

        level1 = new Level(1, "pietro 1",building);
        level2 = new Level(2, "pietro 2",building);

        room11 = new Room(1,"biuro",5, 5, 3,5,50,2,250,level1);
        room12 = new Room(2,"kuchnia",6, 6, 3,10,65,1,325,level1);
        room21 = new Room(3,"stolowka",7, 7, 3,5,50,2,220,level2);
        room22 = new Room(4,"biuro",8, 8, 3,7,55,3,150,level2);

        Visitable[] list = {room11, room12, room21, room22, level1, level2, building};

        for (Visitable calculation : list) {
            calculation.accept(areaCalculator);
            calculation.accept(cubeCalculator);
        }
    }
    @Test
    public void getX() throws Exception {
        Assert.assertEquals(room11.getX(), 5, 0);
        Assert.assertEquals(room12.getX(), 6, 0);
        Assert.assertEquals(room21.getX(), 7, 0);
        Assert.assertEquals(room22.getX(), 8, 0);
    }

    @Test
    public void getY() throws Exception {

        Assert.assertEquals(room11.getY(), 5, 0);
        Assert.assertEquals(room12.getY(), 6, 0);
        Assert.assertEquals(room21.getY(), 7, 0);
        Assert.assertEquals(room22.getY(), 8, 0);
    }

    @Test
    public void getZ() throws Exception {

        Assert.assertEquals(room11.getZ(), 3, 0);
        Assert.assertEquals(room12.getZ(), 3, 0);
        Assert.assertEquals(room21.getZ(), 3, 0);
        Assert.assertEquals(room22.getZ(), 3, 0);

    }

    @Test
    public void getBulbCount() throws Exception {
        Assert.assertEquals(room11.getBulbCount(), 5, 0);
        Assert.assertEquals(room12.getBulbCount(), 10, 0);
        Assert.assertEquals(room21.getBulbCount(), 5, 0);
        Assert.assertEquals(room22.getBulbCount(), 7, 0);
    }

    @Test
    public void getBulbPower() throws Exception {
        Assert.assertEquals(room11.getBulbPower(), 50, 0);
        Assert.assertEquals(room12.getBulbPower(), 65, 0);
        Assert.assertEquals(room21.getBulbPower(), 50, 0);
        Assert.assertEquals(room22.getBulbPower(), 55, 0);
    }

    @Test
    public void getHeaterCount() throws Exception {
        Assert.assertEquals(room11.getHeaterCount(), 2, 0);
        Assert.assertEquals(room12.getHeaterCount(), 1, 0);
        Assert.assertEquals(room21.getHeaterCount(), 2, 0);
        Assert.assertEquals(room22.getHeaterCount(), 3, 0);
    }

    @Test
    public void getHeaterPower() throws Exception {
        Assert.assertEquals(room11.getHeaterPower(), 250, 0);
        Assert.assertEquals(room12.getHeaterPower(), 325, 0);
        Assert.assertEquals(room21.getHeaterPower(), 220, 0);
        Assert.assertEquals(room22.getHeaterPower(), 150, 0);
    }

}