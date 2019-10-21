package com.superfoods.superfoods.main;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//MainController
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {


    //GET
    //URI
    //method - "Main Controller"

//    @RequestMapping(method = RequestMethod.GET, path="/main")
    @GetMapping( path="/main")
    public String main() {

        return "Main Controller";
    }

    @GetMapping(path = "/main-bean")
    public MainBean mainBean() {
        return new MainBean("Main Bean");
    }

    ///main/path-variable/costas
    @GetMapping(path = "/main/path-variable/{name}")
    public MainBean mainPathVariable(@PathVariable String name) {
        //throw new RuntimeException("Something went wrong");
        return new MainBean(String.format("Main Bean, %s", name));
    }
}
