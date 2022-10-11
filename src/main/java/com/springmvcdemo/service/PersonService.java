package com.springmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvcdemo.dao.PersonCRUD;
import com.springmvcdemo.dto.Person;

@Component
public class PersonService {

	@Autowired
	PersonCRUD personCRUD;
	
	public Person createPerson(Person person) {
		
		return personCRUD.createPerson(person);
		
	}
	
	public Person getPersonById(int id) {
		
		return personCRUD.getPersonById(id);
		
	}
	
	public List<Person> getAllPerson(){
		
		return personCRUD.getAllPerson();
		
	}
	
	public Boolean deletePersonById(int id) {
		
		return personCRUD.deletePersonById(id);
		
	}
	
	public Person updatePersonById(Person person, int id) {
		
		return personCRUD.updatePersonById(person, id);
		
	}
	
}
