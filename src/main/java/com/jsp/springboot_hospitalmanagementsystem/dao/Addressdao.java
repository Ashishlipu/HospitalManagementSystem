package com.jsp.springboot_hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Address;
import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.repo.Addressrepo;

@Repository
public class Addressdao {

	@Autowired
	private Addressrepo addressrepo;
	
	public Address saveAddress(Address address) {
		return addressrepo.save(address);
	}
	
	public Address updateAddress(int aid,Address address) {
		if (addressrepo.findById(aid).isPresent()) {
			address.setAid(aid);
			return addressrepo.save(address);
		}else {
			return null;
		}
	}
	
	public Address deleteAddress(int aid) {
		if (addressrepo.findById(aid).isPresent()) {
			Address address=addressrepo.findById(aid).get();
			addressrepo.deleteById(aid);
			return address;
		}else {
			return null;
		}
	}
	
	public Address getAddressbyid(int aid) {
		if (addressrepo.findById(aid).isPresent()) {
			return addressrepo.findById(aid).get();
		}else {
			return null;
		}
	}
}
