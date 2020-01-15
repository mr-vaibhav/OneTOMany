package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Person;
import com.example.service.CreditCardService;
import com.example.service.PersonService;

@RestController
//@Controller
public class PersonController {
	

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	ModelAndView models = new ModelAndView();
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CreditCardService creditCardService;
	
    @RequestMapping(value = "/PersonList", method = RequestMethod.GET)
    public ModelAndView getRecords(Model model) {
    	logger.debug("Received request to show records page");
    	List<Person> persons = personService.getAll();
    	
    	List<Person> person = new ArrayList<Person>();
    	for(Person per : persons) {
    		Person p = new Person();
    		p.setId(per.getId());
    		p.setFirstName(per.getFirstName());
    		p.setMoney(per.getMoney());
    		p.setLastName(per.getLastName());
    		p.setCreditCard(creditCardService.getAll(per.getId()));
    		person.add(p);
    	}
		return new ModelAndView("list","persons",person);
	}
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAdd(Model model) {
    	logger.debug("Received request to show add page");
    	models.setViewName("AddPerson");
    	return models;
	}
    
    @RequestMapping(value = "/personEntry", method = RequestMethod.POST)
    public ModelAndView postAdd(@ModelAttribute("personAttribute") Person person) {
		logger.debug("Received request to add new record");
		personService.add(person);
		return new ModelAndView("redirect:/PersonList");
	}	

}
