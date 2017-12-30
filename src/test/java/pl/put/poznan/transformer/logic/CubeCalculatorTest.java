package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CubeCalculatorTest {

    AreaCalculator areaCalculator;
    CubeCalculator cubeCalculator;
    Room room;
    Level level;
    Building building;
    ArrayList<Room> rooms;
    ArrayList<Level> levels;

    @Before
    public void setUp() throws Exception {
        areaCalculator = new AreaCalculator();
        cubeCalculator = new CubeCalculator();

        rooms = new ArrayList<Room>();
        levels = new ArrayList<Level>();

        room = new Room(1,"biuro",6,6,3,4,60);
        rooms.add(room);
        level = new Level(1,"poziom_1",rooms);
        levels.add(level);
        building= new Building(1,"biurowiec",levels);

        Visitable[] list = {room,level,building};

        for(Visitable calculation:list){
            calculation.accept(areaCalculator);
            calculation.accept(cubeCalculator);
        }
    }
    @Test
    public void visit() throws Exception {
        Assert.assertEquals(building.getCube(),108,0);
    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level.getCube(),108,0);
    }

    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(room.getCube(),108,0);
    }

}