package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.logic.*;

import java.util.ArrayList;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);
    }

    private static ArrayList<Building> myBuildings = new ArrayList<Building>();

    public static ArrayList<Building> getMyBuildings() {
        return myBuildings;
    }
    public static void addToMyList(Building myBuilding) {
        myBuildings.add(myBuilding);
    }

    public static Building findBuildingById(int id) {
        for(int i = 0; i < myBuildings.size(); i++) {
            if (myBuildings.get(i).getId() == id) {
                return myBuildings.get(i);
            }
        }
        return null;
    }

    public static Level findLevelById(int id) {
        for(int i = 0; i < myBuildings.size(); i++) {
            for(int k = 0; k < myBuildings.get(i).getLevels().size(); k++) {
                if (myBuildings.get(i).getLevels().get(k).getId() == id) {
                    return myBuildings.get(i).getLevels().get(k);
                }
            }
        }
        return null;
    }

    public static Building findBuildingByLevelId(int id) {
        for(int i = 0; i < myBuildings.size(); i++) {
            for(int k = 0; k < myBuildings.get(i).getLevels().size(); k++) {
                if (myBuildings.get(i).getLevels().get(k).getId() == id) {
                    return myBuildings.get(i);
                }
            }
        }
        return null;
    }

    public static void calculateAllAttributes(Visitable myLocation) {
        AreaCalculator areaCalculator = new AreaCalculator();
        CubeCalculator cubeCalculator = new CubeCalculator();
        LightingPowerCalculator lightingCalculator = new LightingPowerCalculator();
        myLocation.accept(areaCalculator);
        myLocation.accept(cubeCalculator);
        myLocation.accept(lightingCalculator);
    }


    static {
        Building myBuilding = new Building(1, "White House");
        Level myLevel = new Level(3, "First Level", myBuilding);
        Room myRoom = new Room(4, "First Room", 4, 5, 3,4,200,myLevel);
        Room myRoom2 = new Room(5, "Second Room", 2, 3, 1,5,300,myLevel);
        myBuildings.add(myBuilding);

        myBuilding = new Building(10, "Black House");
        myLevel = new Level(11, "First Level", myBuilding);
        myRoom = new Room(12, "Kitchen", 4, 5, 3,4,200,myLevel);
        myRoom2 = new Room(13, "Garage", 2, 3, 1,5,300,myLevel);
        myBuildings.add(myBuilding);

        myBuilding = new Building(21, "Orange House");
        myLevel = new Level(22, "First Level", myBuilding);
        myRoom = new Room(23, "Toilet1", 4, 5, 3,4,200,myLevel);
        myRoom2 = new Room(24, "Toilet2", 2, 3, 1,5,300,myLevel);
        myBuildings.add(myBuilding);

        myBuilding = new Building(35, "Green House");
        myLevel = new Level(36, "First Level", myBuilding);
        myRoom = new Room(37, "First Corridor", 4, 5, 3,4,200,myLevel);
        myRoom2 = new Room(38, "First Garage", 2, 3, 1,5,300,myLevel);
        Level myLevel2 = new Level(36, "Second Level", myBuilding);
        myRoom = new Room(37, "Living room", 4, 5, 3,4,200,myLevel2);
        myRoom2 = new Room(38, "Bathroom", 2, 3, 1,5,300,myLevel2);
        myBuildings.add(myBuilding);
    }
}
