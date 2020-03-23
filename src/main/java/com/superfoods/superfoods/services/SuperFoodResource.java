package com.superfoods.superfoods.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3001")
//@CrossOrigin(origins="https://e-cantina-demo.co-athanasiou.gr")

public class SuperFoodResource {


    @Autowired
    private SuperFoodService superFoodsService;

    @GetMapping("/{username}/superFoods")
    public List<SuperFood> getAllSuperFood(@PathVariable String username) {


        return superFoodsService.findAll();
    }

    @DeleteMapping("/{username}/superFoods/{id}")
    public ResponseEntity<Void> deleteSuperFood(@PathVariable String username, @PathVariable long id) {

        SuperFood superFood = superFoodsService.deleteById(id);
        if(superFood!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{username}/superFoods/{id}")
    public SuperFood getSuperFoodById(@PathVariable String username, @PathVariable long id) {


        return superFoodsService.findById(id);
    }


    @PutMapping("/{username}/superFoods/{id}")
    public ResponseEntity<SuperFood> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody SuperFood superFood){

        SuperFood superFoodUpdated = superFoodsService.save(superFood);

        return new ResponseEntity<SuperFood>(superFood, HttpStatus.OK);
    }

    @PostMapping("/{username}/superFoods")
    public ResponseEntity<Void> addTodo(
            @PathVariable String username, @RequestBody SuperFood superFood){

        SuperFood createdSuperFood = superFoodsService.save(superFood);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdSuperFood.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
