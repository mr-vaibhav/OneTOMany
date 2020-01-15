package com.example.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.CreditCard;
import com.example.repository.CreditCardRepository;
import com.example.repository.PersonRepository;

@Service
public class CreditCardService {
	
	private static final Logger logger = LoggerFactory.getLogger(CreditCardService.class);
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Resource(name="personService")
	private PersonService personService;
	
	@Transactional
	public void add(CreditCard creditCard) {
		logger.debug("Adding new credit card");
		creditCardRepository.save(creditCard);		
	}

	public List<CreditCard> getAll(Integer id) {
		List<CreditCard> credit = creditCardRepository.getAll(id);
		return credit;
	}

}
