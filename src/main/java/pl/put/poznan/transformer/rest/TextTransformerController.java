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
    @ResponseBody
    @RequestMapping(value = "/area/{idNumber}", method = RequestMethod.GET, produces = "application/json")
    public String getLevelArea(@PathVariable("idNumber") Integer id) {
        // log the parameters
        logger.debug("GET room id=" + id.toString());
        Level level = TextTransformerApplication.findLevelById(id);
        AreaCalculator areaCalculator = new AreaCalculator();
        level.accept(areaCalculator);
        return String.format(new Float(level.getArea()).toString());
    }

}


