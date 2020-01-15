package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Person;
import com.example.repository.CreditCardRepository;
import com.example.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

	
	public List<Person> getAll() {
		logger.debug("Retrieving all persons");
		List<Person> person = personRepository.findAll();
		return person;
	}
	
	public void add(Person person) {
		logger.debug("Adding new person");
		personRepository.save(person);
	}
}
