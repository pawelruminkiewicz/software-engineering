package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import pl.put.poznan.transformer.logic.Level;
//import pl.put.poznan.transformer.logic.Room;

import java.util.ArrayList;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextTransformerApplication.class, args);
//        ArrayList<Room> rooms = new ArrayList<Room>();
//        rooms.add(new Room(1,"aa",2,2,2,2,2));
//        Level level = new Level(rooms);
//        level.setArea(10);
//        level.getRooms().get(0).setArea(9);
//        System.out.println(level.getArea());
//        System.out.println(level.getRooms().get(0).getArea());
    }
}
