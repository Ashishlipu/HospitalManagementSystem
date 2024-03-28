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

import com.jsp.springboot_hospitalmanagementsystem.dto.Address;
import com.jsp.springboot_hospitalmanagementsystem.service.Addressservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class Addresscontroller {

	@Autowired
	private Addressservice addressservice;
	
	@ApiOperation(value = "save address",notes = "api is used to save address")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return addressservice.saveAddress(address);
	}
	
	@ApiOperation(value = "update address",notes = "api is used to update address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Address>> updateAddress(@RequestParam int aid,@Valid @RequestBody Address address) {
		return addressservice.updateAddress(aid, address);
	}
	
	@ApiOperation(value = "delete address",notes = "api is used to delete address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Address>> deleteAddress(@RequestParam int aid) {
		return addressservice.deleteAddress(aid);
	}
	
	@ApiOperation(value = "get address by id",notes = "api is used to find the address based on id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Address>> getAddressbyid(@RequestParam int aid) {
		return addressservice.getAddressbyid(aid);
	}
}
