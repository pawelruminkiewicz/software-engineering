package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Arrays;


@Controller
//@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    @RequestMapping(value="/hello", method=RequestMethod.GET)

    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
        return "hellopage";
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String startpage(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping(value="/addbuilding", method=RequestMethod.GET)
    public String addbuilding(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
        return "addbuildingpage";
    }

    @RequestMapping("/addlevel")
    public String addlevel(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
        return "addlevelpage";
    }

    @RequestMapping("/addroom")
    public String addroom(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        //model.addAttribute("name", name);
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


