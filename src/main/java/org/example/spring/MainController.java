package org.example.spring;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    // GET http://localhost:8080/
    @GetMapping("/")
    public void home() {
        System.out.println("home");
    }
    // GET http://localhost:8080/about
    @GetMapping("/about")
    public void about() {
        System.out.println("about");
    }

    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }
    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 127;
    }
    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 32000;
    }
    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 100_000_000_000_000L;
    }
    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '꽑';
    }
    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }
    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.141592;
    }
    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        String[] arr = {"a", "b", "c"};
        return arr;
    }
    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }
    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("name", "Paul", "hobby", "reading");
    }
}
