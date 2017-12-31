package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class LightingPowerCalculatorTest {
    private LightingPowerCalculator lightCalc;
    private AreaCalculator areaCalc;
    private Room room11;

    private Room room12;
    private Room room21;
    private Room room22;
    private Level level1;
    private Level level2;
    private Building building;
    private ArrayList<Room> rooms1;
    private ArrayList<Room> rooms2;
    private ArrayList<Level> levels;

    @Before
    public void setUp() throws Exception {
        lightCalc = new LightingPowerCalculator();
        areaCalc = new AreaCalculator();
        room11 = new Room(1,"biuro",5, 5, 3,5,50);
        room12 = new Room(2,"kuchnia",6, 6, 3,10,65);
        room21 = new Room(3,"stolowka",7, 7, 3,5,50);
        room22 = new Room(4,"biuro",8, 8, 3,7,55);
        rooms1 = new ArrayList<>();
        rooms2 = new ArrayList<>();
        rooms1.add(room11);
        rooms1.add(room12);
        rooms2.add(room21);
        rooms2.add(room22);
        levels = new ArrayList<>();
        level1 = new Level(1,"pietro 1",rooms1);
        level2 = new Level(2,"pietro 2",rooms2);
        levels.add(level1);
        levels.add(level2);
        building = new Building(1,"Gazownia",levels);
        Visitable[]  list = {room11,room12,room21,room22,level1,level2,building};
        for(Visitable l: list){
            l.accept(areaCalc);
            l.accept(lightCalc);
        }

    }
    @Test
    public void visit() throws Exception {
        Assert.assertEquals(room11.getLight(),10,0.01);
        Assert.assertEquals(room12.getLight(),18.05,0.01);
        Assert.assertEquals(room21.getLight(),5.10,0.01);
        Assert.assertEquals(room22.getLight(),6.01,0.01);
    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level1.getLight(),14.75,0.01);
        Assert.assertEquals(level2.getLight(),5.62,0.01);
    }

    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(building.getLight(),8.82,0.01);
    }

}