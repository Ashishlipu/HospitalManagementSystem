package com.jsp.springboot_hospitalmanagementsystem.dao;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Address;
import com.jsp.springboot_hospitalmanagementsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.repo.Branchrepo;

@Repository
public class Branchdao {

	@Autowired
	private Branchrepo branchrepo;
	
	@Autowired
	private Hospitaldao hospitaldao;
	
	@Autowired
	private Addressdao addressdao;
	
	public Branch saveBranch(Branch branch,int his,int aid) {
		Hospital hospital=hospitaldao.getHospitalbyid(aid);
		Address address=addressdao.getAddressbyid(aid);
		branch.setAddress(address);
		branch.setHospital(hospital);
		return branchrepo.save(branch);
	}
	
	public Branch updateBranch(int bid,Branch branch) {
		Branch branch2=branchrepo.findById(bid).get();
		if (branch2!=null) {
			branch.setBid(bid);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return branchrepo.save(branch);
		}else {
			return null;
		}
	}
	
	public Branch deleteBranch(int bid) {
		if (branchrepo.findById(bid).isPresent()) {
			Branch branch=branchrepo.findById(bid).get();
			branchrepo.deleteById(bid);
			return branch;
		}else {
			return null;
		}
	}
	
	public Branch getBranchbyid(int bid) {
		if (branchrepo.findById(bid).isPresent()) {
			Branch branch=branchrepo.findById(bid).get();
			return branch;
		}else {
			return null;
		}
	}
}
