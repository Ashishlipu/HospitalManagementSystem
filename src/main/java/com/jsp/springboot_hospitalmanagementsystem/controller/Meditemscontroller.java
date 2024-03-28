package com.jsp.springboot_hospitalmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_hospitalmanagementsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagementsystem.service.Meditemservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meditem")
public class Meditemscontroller {

	@Autowired
	private Meditemservice meditemservice;
	
	@ApiOperation(value = "save meditem",notes = "api is used to save meditem")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int mid) {
		return meditemservice.saveMeditems(meditems, mid);
	}
	
	@ApiOperation(value = "update meditem",notes = "api is used to update meditem")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Meditems>> updateMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int id) {
		return meditemservice.updateMeditems(id, meditems);
	}
	
	@ApiOperation(value = "delete meditem",notes = "api is used to delete meditem")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(@RequestParam int id) {
		return meditemservice.deleteMeditems(id);
	}
	
	@ApiOperation(value = "get meditem by id",notes = "api is used to find the meditem based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(@RequestParam int id) {
		return meditemservice.getMeditemsbyid(id);
	}
}
