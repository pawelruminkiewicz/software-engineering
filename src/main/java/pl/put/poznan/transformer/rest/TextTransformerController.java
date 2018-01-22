package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.transformer.logic.*;
import pl.put.poznan.transformer.app.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
//@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    ArrayList<Building> myBuildings = TextTransformerApplication.getMyBuildings();

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

    ///AREA
    @ResponseBody
    @RequestMapping(value = "room/{idNumber}/area", method = RequestMethod.GET, produces = "application/json")
    public String getRoomArea(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET area room id=" + id.toString());
        Room room = TextTransformerApplication.findRoomById(id);
        AreaCalculator areaCalculator = new AreaCalculator();
        room.accept(areaCalculator);
        return String.format(new Float(room.getArea()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "level/{idNumber}/area", method = RequestMethod.GET, produces = "application/json")
    public String getLevelArea(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET area level id=" + id.toString());
        Level level = TextTransformerApplication.findLevelById(id);
        AreaCalculator areaCalculator = new AreaCalculator();
        level.accept(areaCalculator);
        return String.format(new Float(level.getArea()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "building/{idNumber}/area", method = RequestMethod.GET, produces = "application/json")
    public String getBuildingArea(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET area building id=" + id.toString());
        Building building = TextTransformerApplication.findBuildingById(id);
        AreaCalculator areaCalculator = new AreaCalculator();
        building.accept(areaCalculator);
        return String.format(new Float(building.getArea()).toString());
    }

    ///CUBE
    @ResponseBody
    @RequestMapping(value = "room/{idNumber}/cube", method = RequestMethod.GET, produces = "application/json")
    public String getRoomCube(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET cube room id=" + id.toString());
        Room room = TextTransformerApplication.findRoomById(id);
        CubeCalculator cubeCalculator = new CubeCalculator();
        room.accept(cubeCalculator);
        return String.format(new Float(room.getCube()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "level/{idNumber}/cube", method = RequestMethod.GET, produces = "application/json")
    public String getLevelCube(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET cube level id=" + id.toString());
        Level level = TextTransformerApplication.findLevelById(id);
        CubeCalculator cubeCalculator = new CubeCalculator();
        level.accept(cubeCalculator);
        return String.format(new Float(level.getCube()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "building/{idNumber}/cube", method = RequestMethod.GET, produces = "application/json")
    public String getBuildingCube(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET cube building id=" + id.toString());
        Building building = TextTransformerApplication.findBuildingById(id);
        CubeCalculator cubeCalculator = new CubeCalculator();
        building.accept(cubeCalculator);
        return String.format(new Float(building.getCube()).toString());
    }

    ///LIGHT
    @ResponseBody
    @RequestMapping(value = "room/{idNumber}/light", method = RequestMethod.GET, produces = "application/json")
    public String getRoomLight(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET light room id=" + id.toString());
        Room room = TextTransformerApplication.findRoomById(id);
        LightingPowerCalculator lightingCalculator = new LightingPowerCalculator();
        room.accept(lightingCalculator);
        return String.format(new Float(room.getLight()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "level/{idNumber}/light", method = RequestMethod.GET, produces = "application/json")
    public String getLevelLight(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET light level id=" + id.toString());
        Level level = TextTransformerApplication.findLevelById(id);
        LightingPowerCalculator lightingCalculator = new LightingPowerCalculator();
        level.accept(lightingCalculator);
        return String.format(new Float(level.getLight()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "building/{idNumber}/light", method = RequestMethod.GET, produces = "application/json")
    public String getBuildingLight(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET light building id=" + id.toString());
        Building building = TextTransformerApplication.findBuildingById(id);
        LightingPowerCalculator lightingCalculator = new LightingPowerCalculator();
        building.accept(lightingCalculator);
        return String.format(new Float(building.getLight()).toString());
    }

    ///HEATING
    @ResponseBody
    @RequestMapping(value = "room/{idNumber}/heating", method = RequestMethod.GET, produces = "application/json")
    public String getRoomHeating(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET heating room id=" + id.toString());
        Room room = TextTransformerApplication.findRoomById(id);
        HeatingPowerCalculator heatingCalculator = new HeatingPowerCalculator();
        room.accept(heatingCalculator);
        return String.format(new Float(room.getHeating()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "level/{idNumber}/heating", method = RequestMethod.GET, produces = "application/json")
    public String getLevelHeating(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET heating level id=" + id.toString());
        Level level = TextTransformerApplication.findLevelById(id);
        HeatingPowerCalculator heatingCalculator = new HeatingPowerCalculator();
        level.accept(heatingCalculator);
        return String.format(new Float(level.getHeating()).toString());
    }

    @ResponseBody
    @RequestMapping(value = "building/{idNumber}/heating", method = RequestMethod.GET, produces = "application/json")
    public String getBuildingHeating(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET heating building id=" + id.toString());
        Building building = TextTransformerApplication.findBuildingById(id);
        HeatingPowerCalculator heatingCalculator = new HeatingPowerCalculator();
        building.accept(heatingCalculator);
        return String.format(new Float(building.getHeating()).toString());
    }

    ///GENERAL
    @ResponseBody // nie zwraca errora 500 tylko null
    @RequestMapping(value = "room/{idNumber}", method = RequestMethod.GET, produces = "application/json")
    public Room getRoom(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET room id=" + id.toString());
        return TextTransformerApplication.findRoomById(id);
    }

    @ResponseBody // nie zwraca errora 500 tylko null
    @RequestMapping(value = "level/{idNumber}", method = RequestMethod.GET, produces = "application/json")
    public Level getLevel(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET level id=" + id.toString());
        return TextTransformerApplication.findLevelById(id);
    }

    @ResponseBody
    @RequestMapping(value = "building/{idNumber}", method = RequestMethod.GET, produces = "application/json")
    public Building getBuilding(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET building id=" + id.toString());
        return myBuildings.get(id);
    }

    @ResponseBody
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public ArrayList<Building> getAll() {
        // log the parameters
        logger.debug("GET all");
        return myBuildings;
    }
}


