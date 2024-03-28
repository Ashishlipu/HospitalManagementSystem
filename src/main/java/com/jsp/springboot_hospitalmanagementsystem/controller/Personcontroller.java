package com.jsp.springboot_hospitalmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_hospitalmanagementsystem.dto.Person;
import com.jsp.springboot_hospitalmanagementsystem.service.Personservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class Personcontroller {

	@Autowired
	private Personservice personservice;
	
	@ApiOperation(value = "save person",notes = "api is used to save person")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personservice.savePerson(person);
	}
	
	@ApiOperation(value = "update person",notes = "api is used to update person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Person>> updatePerson(@Valid @RequestBody Person person,@RequestParam int pid) {
		return personservice.updatePerson(pid, person);
	}
	
	@ApiOperation(value = "delete person",notes = "api is used to delete person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Person>> deletePerson(@RequestParam int pid) {
		return personservice.delePerson(pid);
	}
	
	@ApiOperation(value = "get person by id",notes = "api is used to find the person based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Person>> getPersonbyid(@RequestParam int pid) {
		return personservice.getPersonbyid(pid);
	}
}
