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

import com.jsp.springboot_hospitalmanagementsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagementsystem.service.Medorderservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class Medordercontroller {

	@Autowired
	private Medorderservice medorderservice;
	
	@ApiOperation(value = "save medorder",notes = "api is used to save medorder")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Medorder>> saveMedorder(@Valid @RequestBody Medorder medorder,@RequestParam int eid) {
		return medorderservice.saveMedorder(medorder, eid);
	}
	
	@ApiOperation(value = "update medorder",notes = "api is used to update medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Medorder>> updateMedorder(@Valid @RequestBody Medorder medorder,@RequestParam int mid) {
		return medorderservice.updateMedorder(medorder, mid);
	}
	
	@ApiOperation(value = "delete medorder",notes = "api is used to delete medorder")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Medorder>> deleteMedorder(@RequestParam int mid) {
		return medorderservice.deleteMedorder(mid);
	}
	
	@ApiOperation(value = "get medorder by id",notes = "api is used to find the medorder based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Medorder>> getMedorderbyid(@RequestParam int mid) {
		return medorderservice.getMedorderbyid(mid);
	}
}
