package com.jsp.springboot_hospitalmanagementsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.repo.Hospitalrepo;

@Repository
public class Hospitaldao {

	@Autowired
	private Hospitalrepo hospitalrepo;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalrepo.save(hospital);
	}
	
	public Hospital updateHospital(int hid,Hospital hospital) {
		if (hospitalrepo.findById(hid).isPresent()) {
			hospital.setId(hid);
			return hospitalrepo.save(hospital);
		}else {
			return null;
		}
	}
	
    public Hospital deleteHospital(int hid) {
		if (hospitalrepo.findById(hid).isPresent()) {
			Hospital hospital=hospitalrepo.findById(hid).get();
			hospitalrepo.deleteById(hid);
			return hospital;
		}else {
			return null;
		}
	}
    
    public Hospital getHospitalbyid(int hid) {
    	
    	//Optional is used because it means value may be there or may not be there
    	
		Optional<Hospital> hospital=hospitalrepo.findById(hid);
		if (hospital.isPresent()) {
			return hospital.get();
		}else {
			return null;
		}
	}
    
    public Hospital gethospitalbyemail(String email) {
  		return hospitalrepo.findbyemail(email);
  		
  	}
}
