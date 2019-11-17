package com.superfoods.superfoods.services;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins="http://localhost:3000")
//@CrossOrigin(origins="https://e-cantina.co-athanasiou.gr")
public class SuperFoodJpaResource {
	

	@Autowired
	private SuperFoodJpaRepository superFoodJpaRepository;


	@GetMapping(path="/jpa/{username}/superFoods")
	public List<SuperFood> getAllSuperFood(@PathVariable String username){
		return superFoodJpaRepository.findByUsername(username);

	}

	@GetMapping("/jpa/{username}/superFoods/{id}")
	public SuperFood getSuperFood(@PathVariable String username, @PathVariable long id){
		return superFoodJpaRepository.findById(id).get();

	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/jpa/{username}/superFoods/{id}")
	public ResponseEntity<Void> deleteSuperFood(
			@PathVariable String username, @PathVariable long id) {

		superFoodJpaRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	

	//Edit/Update a superFood
	//PUT /users/{user_name}/superFoods/{todo_id}
	@PutMapping("/jpa/{username}/superFoods/{id}")
	public ResponseEntity<SuperFood> updateSuperFood(
			@PathVariable String username,
			@PathVariable long id, @RequestBody SuperFood superFood){

		superFood.setUsername(username);

		SuperFood superFoodUpdated = superFoodJpaRepository.save(superFood);
		
		return new ResponseEntity<SuperFood>(superFood, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/{username}/superFoods")
	public ResponseEntity<Void> createSuperFood(
			@PathVariable String username, @RequestBody SuperFood superFood){

		superFood.setUsername(username);

		SuperFood createdSuperFood = superFoodJpaRepository.save(superFood);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdSuperFood.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}
