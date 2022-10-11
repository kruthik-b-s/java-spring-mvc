package com.springmvcdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springmvcdemo.dto.Person;

@Component
public class PersonCRUD {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Person createPerson(Person person) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();

		return entityManager.find(person.getClass(), person.getId());

	}

	public Person getPersonById(int id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = new Person();

		return entityManager.find(person.getClass(), id);

	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select person from Person person");

		return query.getResultList();

	}

	public Boolean deletePersonById(int id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = new Person();
		person = entityManager.find(person.getClass(), id);

		if (person != null) {

			entityManager.getTransaction().begin();
			entityManager.remove(person);
			entityManager.getTransaction().commit();
			return true;

		} else {

			return false;

		}

	}

	public Person updatePersonById(Person person, int id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		if (entityManager.find(person.getClass(), id) != null) {

			person.setId(id);
			entityManager.getTransaction().begin();
			entityManager.merge(person);
			entityManager.getTransaction().commit();
			return person;

		} else {

			return null;

		}

	}

}
