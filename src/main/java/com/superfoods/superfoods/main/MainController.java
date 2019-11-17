package com.superfoods.superfoods.main;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//MainController
@RestController
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins="https://e-cantina.co-athanasiou.gr")
public class MainController {


    @GetMapping( path="/")
    public String home() {

        return "Home Page";
    }

    //GET
    //URI
    //method - "Main Controller"

//    @RequestMapping(method = RequestMethod.GET, path="/main")
    @GetMapping( path="/jpa/main")
    public String main() {

        return "Main Controller";
    }

    @GetMapping(path = "/jpa/main-bean")
    public MainBean mainBean() {
        return new MainBean("Main Bean");
    }

    ///main/path-variable/costas
    @GetMapping(path = "/jpa/main/path-variable/{name}")
    public MainBean mainPathVariable(@PathVariable String name) {
        //throw new RuntimeException("Something went wrong");
        return new MainBean(String.format("Main Bean, %s", name));
    }
}
