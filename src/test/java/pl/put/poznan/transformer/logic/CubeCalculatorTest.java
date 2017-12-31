package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CubeCalculatorTest {

    AreaCalculator areaCalculator;
    CubeCalculator cubeCalculator;
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
        cubeCalculator = new CubeCalculator();

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
            calculation.accept(cubeCalculator);
        }
    }

    @Test
    public void visit() throws Exception {
        Assert.assertEquals(building.getCube(), 522, 0);
    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level1.getCube(), 183, 0);
        Assert.assertEquals(level2.getCube(), 339, 0);
    }

    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(room11.getCube(), 75, 0);
        Assert.assertEquals(room12.getCube(), 108, 0);
        Assert.assertEquals(room21.getCube(), 147, 0);
        Assert.assertEquals(room22.getCube(), 192, 0);
    }

}