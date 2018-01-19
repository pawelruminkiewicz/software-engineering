package pl.put.poznan.transformer.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AlertTest {
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
        building = new Building(1, "Gazownia", 3);
        levels = new ArrayList<>();
        level1 = new Level(1, "pietro 1", building);
        level2 = new Level(2, "pietro 2", building);
        levels.add(level1);
        levels.add(level2);
        room11 = new Room(1, "biuro", 5, 5, 3, 5, 50, 2, 250, level1);
        room12 = new Room(2, "kuchnia", 6, 6, 3, 10, 65, 1, 325, level1);
        room21 = new Room(3, "stolowka", 7, 7, 3, 5, 50, 2, 220, level2);
        room22 = new Room(4, "biuro", 8, 8, 3, 7, 55, 3, 150, level2);
        rooms1 = new ArrayList<>();
        rooms2 = new ArrayList<>();
        rooms1.add(room11);
        rooms1.add(room12);
        rooms2.add(room21);
        rooms2.add(room22);
        Visitable[] list = {room11, room12, room21, room22, level1, level2, building};
        Alert alert = new Alert(building);

        for(Visitable l: list){
            l.accept(cubeCalc);
            l.accept(heatCalc);
        }

        for(Level lvl : building.getLevels()){
            for(Room r : lvl.getRooms()){
                alert.calculate(r);
            }
        }

    }
    @Test
    public void calculate(){

        Assert.assertEquals(room11.isAlerted(),true);
        Assert.assertEquals(room12.isAlerted(),true);
        Assert.assertEquals(room21.isAlerted(),false);
        Assert.assertEquals(room22.isAlerted(),false);
    }

}