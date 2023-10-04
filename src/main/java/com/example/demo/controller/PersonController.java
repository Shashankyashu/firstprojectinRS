package com.example.demo.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private  PersonService PersonService;
	
	// http://localhost:8080/save
	@PostMapping("/save")
	public ResponseEntity<Person> savePersonWithAadhar(@RequestBody Person person){
		
		Person savedperson=PersonService.savePersonWithAadhar(person);
		return ResponseEntity.ok(savedperson);	
	}

	// http://localhost:8080/get/78656897537
	@GetMapping("/get/{adharNumber}")
	public ResponseEntity<Person> getPersonByAadhar(@PathVariable String adharNumber) {
		Optional<Person> person=PersonService.getPersonByAadharNumber(adharNumber);
		return person.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	// http://localhost:8080/update/1
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody Person updatPerson){
	PersonService.updatePerson(id, updatPerson);
		return ResponseEntity.ok("person with ID"+id+ "updated succesfully");
		
	}
	//http://localhost:8080/delete?id=1
	@DeleteMapping("/delete")
	public ResponseEntity<String>deletePerson(@RequestParam Long id){
		PersonService.deletePerson(id);
		return ResponseEntity.ok("deleted");
	}
}