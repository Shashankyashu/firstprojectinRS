package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.module.Person;
import com.example.demo.repo.AadharCardRepo;
import com.example.demo.repo.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo personRepo; 
	@Autowired
	private AadharCardRepo aadharCardRepo;

	public Person savePersonWithAadhar(Person person) {
		return personRepo.save(person);
	}
	public Optional<Person> getPersonByAadharNumber(String adharNumber) {
		return personRepo.findByAadharCard_AdharNumber(adharNumber);
	}
	public Person updatePerson(Long id,Person updatPerson){
		Optional<Person> presentPerson
		=getPersonByAadharNumber(updatPerson.getAadharCard().getAdharNumber());
		if(presentPerson.isPresent()) {
			updatPerson.setId(id);
			Person savedPerson=savePersonWithAadhar(updatPerson);
			return savedPerson;
		}
		else {
			return null;
		}
	}
	public Person deletePerson(Long id) {
		Person person=personRepo.findById(id).orElse(null);
		if(person!=null) {
			personRepo.delete(person);
			return person;
		}else {
			return null;
		}
	}
}


