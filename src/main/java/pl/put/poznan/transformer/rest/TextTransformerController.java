package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
//@RequestMapping("/{text}")
public class TextTransformerController {
    private static ArrayList<Building> myBuildings = new ArrayList<Building>();

    public static void addToMyList(Building myBuilding) {
        myBuildings.add(myBuilding);
    }

    public static Building findBuildingById(int id) {
        for(int i = 0; i<myBuildings.size(); i++) {
            if (myBuildings.get(i).getId() == id) {
                return myBuildings.get(i);
            }
        }
        return null;
    }

    public static Level findLevelById(int id) {
        for(int i = 0; i<myBuildings.size(); i++) {
            for(int k = 0; k < myBuildings.get(i).getLevels().size(); k++) {
                if (myBuildings.get(i).getLevels().get(k).getId() == id) {
                    return myBuildings.get(i).getLevels().get(k);
                }
            }
        }
        return null;
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

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("message", myBuildings);
        return "register";
    }

    @RequestMapping(value="/insert", method=RequestMethod.POST)
    public String hellos(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
        System.out.println("tutaj");
        return "insert";
    }


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String startPage(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "index";
    }



    @RequestMapping(value="/addbuilding", method=RequestMethod.GET)
    public String addBuilding(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addbuildingpage";
    }

    @RequestMapping(value="/addbuilding", method=RequestMethod.POST)
    public String addBuildingCreate(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addbuildingpage";
    }



    @RequestMapping(value="/addlevel", method=RequestMethod.GET)
    public String addLevel(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addlevelpage";
    }

    @RequestMapping(value="/addlevel", method=RequestMethod.POST)
    public String addLevelCreate(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addlevelpage";
    }



    @RequestMapping(value="/addroom", method=RequestMethod.GET)
    public String addRoom(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addroompage";
    }

    @RequestMapping(value="/addroom", method=RequestMethod.POST)
    public String addRoomCreate(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("myBuildingList", myBuildings);
        return "addroompage";
    }
    /*
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        System.out.println("UP");
        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                      @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));
        System.out.println("hahah");
        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
    */


}


