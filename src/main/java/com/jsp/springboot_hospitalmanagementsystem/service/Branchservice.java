package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Branchdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Branchservice {

	@Autowired
	private Branchdao branchdao;
	
	public ResponseEntity<Responsestructure<Branch>> saveBranch(Branch branch,int hid,int aid) {
		Responsestructure<Branch> responsestructure=new Responsestructure<Branch>();
		responsestructure.setMessage("successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(branchdao.saveBranch(branch, hid, aid));
		
		return new ResponseEntity<Responsestructure<Branch>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Branch>> updateBranch(Branch branch,int bid) {
		Branch branch2=branchdao.updateBranch(bid, branch);
		if (branch2!=null) {
			Responsestructure<Branch> responsestructure=new Responsestructure<Branch>();
			responsestructure.setMessage("successfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(branch2);
			
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for branch");
		}
	}
	
	public ResponseEntity<Responsestructure<Branch>> deleteBranch(int bid) {
		Branch branch=branchdao.deleteBranch(bid);
		if (branch!=null) {
			Responsestructure<Branch> responsestructure=new Responsestructure<Branch>();
			responsestructure.setMessage("successfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(branch);
			
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for branch");
		}
	}
	public ResponseEntity<Responsestructure<Branch>> getBranchbyid(int bid) {
		Branch branch=branchdao.getBranchbyid(bid);
		if (branch!=null) {
			Responsestructure<Branch> responsestructure=new Responsestructure<Branch>();
			responsestructure.setMessage("successfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(branch);
			
			return new ResponseEntity<Responsestructure<Branch>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
