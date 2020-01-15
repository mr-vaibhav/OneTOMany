package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.CreditCard;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.CreditCardService;
import com.example.service.PersonService;

@RestController
//@Controller
@RequestMapping(("/main/creditcard"))
public class CreditCardController {
	
	private static final Logger logger = LoggerFactory.getLogger(CreditCardController.class);
	
	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	 PersonRepository personService;
	
	ModelAndView models = new ModelAndView();
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public ModelAndView getAdd(@PathVariable(value = "id") Integer personId,Model model) {
    	logger.debug("Received request to show add page");
    	model.addAttribute("creditCardAttribute", new CreditCard());
    	model.addAttribute("personId", personId);
    	return new ModelAndView("AddCard","personId",personId);
    	//return "AddCard";
	}
	
	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	//@PostMapping(value = "/addCard")
    public ModelAndView postAdd(@RequestParam("personId") Integer personId,@ModelAttribute("creditCardAttribute") CreditCard creditCard,BindingResult binding) { //@RequestBody  CreditCard creditCard @ModelAttribute("creditCard") CreditCard creditCard
		//@RequestParam("personId") Integer personId
		//@PathVariable(value = "id") Integer personId
		logger.debug("Received request to add new credit card");
		logger.debug("-------------------->-------------------->------------------->");
		logger.debug("Integer Value Received Is" + " " + personId);
		Person p = personService.findById(personId).get();
		logger.debug("The Value Printed in the Person Object" + " "+p.getId());
		creditCard.setPerson(p);
		creditCardService.add(creditCard);
		//return "Success";
		return new ModelAndView("redirect:/PersonList");
	}

}
