package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AreaCalculatorTest {

    private AreaCalculator areaCalculator;
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

        building = new Building(1, "Gazownia");

        level1 = new Level(1, "pietro 1", building);
        level2 = new Level(2, "pietro 2", building);

        room11 = new Room(1,"biuro",5, 5, 3,5,50,2,250,level1);
        room12 = new Room(2,"kuchnia",6, 6, 3,10,65,1,325,level1);
        room21 = new Room(3,"stolowka",7, 7, 3,5,50,2,220,level2);
        room22 = new Room(4,"biuro",8, 8, 3,7,55,3,150,level2);

        Visitable[] list = {room11, room12, room21, room22, level1, level2, building};

        for (Visitable calculation : list) {
            calculation.accept(areaCalculator);
        }
    }

    @Test
    public void visit() throws Exception {
        Assert.assertEquals(building.getArea(), 174, 0);
    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level1.getArea(), 61, 0);
        Assert.assertEquals(level2.getArea(), 113, 0);
    }

    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(room11.getArea(), 25, 0);
        Assert.assertEquals(room12.getArea(), 36, 0);
        Assert.assertEquals(room21.getArea(), 49, 0);
        Assert.assertEquals(room22.getArea(), 64, 0);
    }

}