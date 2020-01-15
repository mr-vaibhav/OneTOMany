package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "creditcarddb")
public class CreditCard {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Integer id;
	  
	 @Column(name = "type")
	 private String type;
	  
	 @Column(name = "number")
	 private String number;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="person_id", nullable=false)
	 private Person person;

	 
	 
	public CreditCard() {
		super();
	}



	public CreditCard(Integer id, String type, String number, Person person) {
		super();
		this.id = id;
		this.type = type;
		this.number = number;
		this.person = person;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}
	 
	
	
	 

}
