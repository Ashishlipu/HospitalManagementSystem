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

import com.jsp.springboot_hospitalmanagementsystem.dto.Encounter;
import com.jsp.springboot_hospitalmanagementsystem.service.Encounterservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class Encountercontroller {

	@Autowired
	private Encounterservice encounterservice;
	
	@ApiOperation(value = "save encounter",notes = "api is used to save encounter")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid) {
		return encounterservice.saveEncounter(encounter, pid, bid);
	}
	
	@ApiOperation(value = "update encounter",notes = "api is used to update encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Encounter>> updatEncounter(@Valid @RequestBody Encounter encounter,@RequestParam int eid,@RequestParam int bid) {
		return encounterservice.updatEncounter(eid, encounter, bid);
	}
	
	@ApiOperation(value = "delete encounter",notes = "api is used to delete encounter")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Encounter>> deleteEncounter(@RequestParam int eid) {
		return encounterservice.deletEncounter(eid);
	}
	
	@ApiOperation(value = "get encounter by id",notes = "api is used to find the encounter based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Encounter>> getEncounterbyid(@RequestParam int eid) {
		return encounterservice.getEncounterbyid(eid);
	}
}
