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

import com.jsp.springboot_hospitalmanagementsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagementsystem.service.Branchservice;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class Branchcontroller {

	@Autowired
	private Branchservice branchservice;
	
	@ApiOperation(value = "save branch",notes = "api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<Responsestructure<Branch>> saveBranch(@Valid @RequestBody Branch branch,@RequestParam int hid,@RequestParam int aid) {
		return branchservice.saveBranch(branch, hid, aid);
	}
	
	@ApiOperation(value = "update branch",notes = "api is used to update branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	   @ApiResponse(code = 404,message = "id not found")
	@PutMapping
	public ResponseEntity<Responsestructure<Branch>> updateBranch(@Valid @RequestBody Branch branch,@RequestParam int bid) {
		return branchservice.updateBranch(branch, bid);
	}
	
	@ApiOperation(value = "delete branch",notes = "api is used to delete branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted")})
	   @ApiResponse(code = 404,message = "id not found")
	@DeleteMapping
	public ResponseEntity<Responsestructure<Branch>> deleteBranch(@RequestParam int bid) {
		return branchservice.deleteBranch(bid);
	}
	
	@ApiOperation(value = "get branch by id",notes = "api is used to find the branch based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found")})
	   @ApiResponse(code = 404,message = "id not found")
	@GetMapping
	public ResponseEntity<Responsestructure<Branch>> getBranchbyid(@RequestParam int bid) {
		return branchservice.getBranchbyid(bid);
	}
}
