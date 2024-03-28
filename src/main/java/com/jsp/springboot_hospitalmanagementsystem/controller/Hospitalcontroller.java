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

import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.service.Hospitalservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class Hospitalcontroller {

	@Autowired
	private Hospitalservice hospitalservice;

	@ApiOperation(value = "save hospital",notes = "api is used to save hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital) {
		return hospitalservice.saveHospital(hospital);
	}

	@ApiOperation(value = "update hospital",notes = "api is used to update hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Hospital>> updateHospital(@Valid @RequestParam int hid,
			@RequestBody Hospital hospital) {
		return hospitalservice.updateHospital(hid, hospital);
	}

	@ApiOperation(value = "delete hospital",notes = "api is used to delete hospital")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hospital>> deleteHospital(@RequestParam int hid) {
		return hospitalservice.deleteHospital(hid);
	}

	@ApiOperation(value = "get hospital by id",notes = "api is used to find the hospital based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Hospital>> getHospitalbyid(@RequestParam int hid) {
		return hospitalservice.getHospital(hid);
	}

	@ApiOperation(value = "get hospital by email",notes = "api is used to find the hospital based on email")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
  	@GetMapping("/getbyemail")
	public ResponseEntity<Responsestructure<Hospital>> gethospitalbyemail(@RequestParam String email) {
		return hospitalservice.gethospitalbyemail(email);
}
}
