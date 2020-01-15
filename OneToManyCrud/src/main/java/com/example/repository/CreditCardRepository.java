package com.example.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer>{
	
	@Query("SELECT v FROM Person u INNER JOIN  u.creditCard v  WHERE u.id = ?1")
	 List<CreditCard>  getAll(Integer id);

}
