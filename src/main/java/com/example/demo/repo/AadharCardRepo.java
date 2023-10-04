package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.module.AadharCard;

public interface AadharCardRepo extends JpaRepository<AadharCard, String>{

}
