package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
	
	
	

}
