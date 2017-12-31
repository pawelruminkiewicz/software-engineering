package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AreaCalculatorTest {

    AreaCalculator areaCalculator;
    Room room11;
    Room room12;
    Room room21;
    Room room22;
    Level level1;
    Level level2;
    Building building;
    ArrayList<Room> rooms1;
    ArrayList<Room> rooms2;
    ArrayList<Level> levels;

    @Before
    public void setUp() throws Exception {
        areaCalculator = new AreaCalculator();

        room11 = new Room(1, "biuro", 5, 5, 3, 5, 50);
        room12 = new Room(2, "kuchnia", 6, 6, 3, 10, 65);
        room21 = new Room(3, "stolowka", 7, 7, 3, 5, 50);
        room22 = new Room(4, "biuro", 8, 8, 3, 7, 55);
        rooms1 = new ArrayList<>();
        rooms2 = new ArrayList<>();
        levels = new ArrayList<>();
        rooms1.add(room11);
        rooms1.add(room12);
        rooms2.add(room21);
        rooms2.add(room22);
        level1 = new Level(1, "pietro 1", rooms1);
        level2 = new Level(2, "pietro 2", rooms2);
        levels.add(level1);
        levels.add(level2);
        building = new Building(1, "Gazownia", levels);

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