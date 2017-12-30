package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AreaCalculatorTest {

    AreaCalculator areaCalculator;
    Room room1;
    Room room2;
    Room room3;
    Level level;
    Building building;
    ArrayList<Room> rooms;
    ArrayList<Level> levels;

    @Before
    public void setUp() throws Exception {
        areaCalculator = new AreaCalculator();

        rooms = new ArrayList<Room>();
        levels = new ArrayList<Level>();

        room1 = new Room(1,"biuro",6,6,3,4,60);
        room2 = new Room(1,"stolowka",8,7,4,4,60);
        room3 = new Room(1,"kuchnia",20,15,2,4,60);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        level = new Level(1,"poziom_1",rooms);
        levels.add(level);
        building= new Building(1,"biurowiec",levels);

        Visitable[] list = {room1,room2,room3,level,building};

        for(Visitable calculation:list){
            calculation.accept(areaCalculator);
        }
    }

    @Test
    public void visit() throws Exception {
        Assert.assertEquals(building.getArea(),392,0);
    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level.getArea(),392,0);
    }

    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(room1.getArea(),36,0);
        Assert.assertEquals(room2.getArea(),56,0);
        Assert.assertEquals(room3.getArea(),300,0);
    }

}