package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Persondao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Person;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Personservice {

	@Autowired
	private Persondao persondao;
	
	public ResponseEntity<Responsestructure<Person>> savePerson(Person person) {
		Responsestructure<Person> responsestructure=new Responsestructure<Person>();
		responsestructure.setMessage("Successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(persondao.savePerson(person));
		
		return new ResponseEntity<Responsestructure<Person>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Person>> updatePerson(int pid,Person person) {
		Person person2=persondao.updatePerson(pid, person);
		if (person2!=null) {
			Responsestructure<Person> responsestructure=new Responsestructure<Person>();
			responsestructure.setMessage("Successfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(person2);
			
			return new ResponseEntity<Responsestructure<Person>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for person");
		}
	}
	
	public ResponseEntity<Responsestructure<Person>> delePerson(int pid) {
		Person person=persondao.deletePerson(pid);
		if (person!=null) {
			Responsestructure<Person> responsestructure=new Responsestructure<Person>();
			responsestructure.setMessage("Successfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(person);
			
			return new ResponseEntity<Responsestructure<Person>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for person");
		}
	}
	
	public ResponseEntity<Responsestructure<Person>> getPersonbyid(int pid) {
		Person person=persondao.getPersonbyid(pid);
		if (person!=null) {
			Responsestructure<Person> responsestructure=new Responsestructure<Person>();
			responsestructure.setMessage("Successfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(person);
			
			return new ResponseEntity<Responsestructure<Person>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
