package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HeatingPowerCalculatorTest {

    private HeatingPowerCalculator heatCalc;
    private CubeCalculator cubeCalc;
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
        heatCalc = new HeatingPowerCalculator();
        cubeCalc = new CubeCalculator();
        building = new Building(1,"Gazownia");
        levels = new ArrayList<>();
        level1 = new Level(1,"pietro 1",building);
        level2 = new Level(2,"pietro 2",building);
        levels.add(level1);
        levels.add(level2);
        room11 = new Room(1,"biuro",5, 5, 3,5,50,2,250,level1);
        room12 = new Room(2,"kuchnia",6, 6, 3,10,65,1,325,level1);
        room21 = new Room(3,"stolowka",7, 7, 3,5,50,2,220,level2);
        room22 = new Room(4,"biuro",8, 8, 3,7,55,3,150,level2);
        rooms1 = new ArrayList<>();
        rooms2 = new ArrayList<>();
        rooms1.add(room11);
        rooms1.add(room12);
        rooms2.add(room21);
        rooms2.add(room22);
        Visitable[]  list = {room11,room12,room21,room22,level1,level2,building};
        for(Visitable l: list){
            l.accept(cubeCalc);
            l.accept(heatCalc);
        }

    }

    @Test
    public void visit() throws Exception {

        Assert.assertEquals(room11.getHeating(),6.67,0.01);
        Assert.assertEquals(room12.getHeating(),3.01,0.01);
        Assert.assertEquals(room21.getHeating(),2.99,0.01);
        Assert.assertEquals(room22.getHeating(),2.34,0.01);

    }

    @Test
    public void visit1() throws Exception {
        Assert.assertEquals(level1.getHeating(),4.51,0.01);
        Assert.assertEquals(level2.getHeating(),2.63,0.01);
    }
    @Test
    public void visit2() throws Exception {
        Assert.assertEquals(building.getHeating(),3.29,0.01);
    }

}