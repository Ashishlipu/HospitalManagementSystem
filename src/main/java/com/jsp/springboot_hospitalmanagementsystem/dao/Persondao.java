package com.jsp.springboot_hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Person;
import com.jsp.springboot_hospitalmanagementsystem.repo.Personrepo;

@Repository
public class Persondao {

	@Autowired
	private Personrepo personrepo;
	
	public Person savePerson(Person person) {
		return personrepo.save(person);
	}
	
	public Person updatePerson(int pid,Person person) {
		if (personrepo.findById(pid).isPresent()) {
			person.setPid(pid);
			return personrepo.save(person);
		}else {
			return null;
		}
	}
	
	public Person deletePerson(int pid) {
		if (personrepo.findById(pid).isPresent()) {
			Person person=personrepo.findById(pid).get();
			personrepo.deleteById(pid);
			return person;
		}else {
			return null;
		}
	}
	
	public Person getPersonbyid(int pid) {
		if (personrepo.findById(pid).isPresent()) {
			Person person=personrepo.findById(pid).get();
			return person;
		}else {
			return null;
		}
	}
}
