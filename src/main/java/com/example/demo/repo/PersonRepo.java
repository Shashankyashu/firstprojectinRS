package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.module.Person;

public interface PersonRepo extends JpaRepository<Person, Long>{
	
	Optional<Person> findByAadharCard_AdharNumber(String adharNumber);


}
