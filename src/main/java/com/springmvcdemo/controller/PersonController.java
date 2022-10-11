package com.springmvcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcdemo.dto.Person;
import com.springmvcdemo.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping("/home")
	public ModelAndView showAllPerson() {

		ModelAndView modelAndView = new ModelAndView("viewallperson.jsp");

		List<Person> persons = personService.getAllPerson();

		modelAndView.addObject("persons", persons);

		return modelAndView;

	}

	@RequestMapping("/addperson")
	public ModelAndView savePerson() {

		ModelAndView modelAndView = new ModelAndView("saveperson.jsp");

		modelAndView.addObject("person", new Person());

		return modelAndView;

	}

	@RequestMapping("/update")
	public ModelAndView updatePerson(@RequestParam(name = "id") int id) {

		ModelAndView modelAndView = new ModelAndView("updateperson.jsp");

		Person person = personService.getPersonById(id);

		modelAndView.addObject("person", person);

		return modelAndView;

	}

	@RequestMapping("/saveperson")
	public ModelAndView registerPerson(@ModelAttribute Person person) {

		Person result = personService.createPerson(person);

		ModelAndView modelAndView = new ModelAndView("common.jsp");

		if (result != null) {

			modelAndView.addObject("message", "Person added sucessfully.....");

		} else {

			modelAndView.addObject("message", "Person was not added......");

		}

		return modelAndView;

	}

	@RequestMapping("/remove")
	public ModelAndView deletePerson(@RequestParam(name = "id") int id) {

		ModelAndView modelAndView = null;

		if (personService.deletePersonById(id)) {

			modelAndView = new ModelAndView("viewallperson.jsp");

			List<Person> persons = personService.getAllPerson();

			modelAndView.addObject("persons", persons);

		} else {

			modelAndView = new ModelAndView("common.jsp");
			modelAndView.addObject("message", "Person was not deleted......");

		}

		return modelAndView;

	}

	@RequestMapping(path = "/updateperson", method = RequestMethod.POST)
	public ModelAndView updateDisplay(@ModelAttribute Person person) {

		ModelAndView modelAndView = null;

		if (personService.updatePersonById(person, person.getId()) != null) {

			modelAndView = new ModelAndView("viewallperson.jsp");
			
			List<Person> persons = personService.getAllPerson();

			modelAndView.addObject("persons", persons);

		} else {

			modelAndView = new ModelAndView("common.jsp");
			modelAndView.addObject("message", "Person was not updated.....");

		}

		return modelAndView;

	}

}
