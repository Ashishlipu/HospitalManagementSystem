package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Addressdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Address;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Addressservice {

	@Autowired
	private Addressdao addressdao;
	
	public ResponseEntity<Responsestructure<Address>> saveAddress(Address address) {
		Responsestructure<Address> responsestructure=new Responsestructure<Address>();
		responsestructure.setMessage("Successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(addressdao.saveAddress(address));
		
		return new ResponseEntity<Responsestructure<Address>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Address>> updateAddress(int aid,Address address) {
		Address address2=addressdao.updateAddress(aid, address);
		Responsestructure<Address> responsestructure=new Responsestructure<Address>();
		if (address2!=null) {
			responsestructure.setMessage("Successfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(address2);
			return new ResponseEntity<Responsestructure<Address>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for address");
		}
	}
	
	public ResponseEntity<Responsestructure<Address>> deleteAddress(int aid) {
		Address address=addressdao.deleteAddress(aid);
		if (address!=null) {
			Responsestructure<Address> responsestructure=new Responsestructure<Address>();
			responsestructure.setMessage("Successfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(address);
			return new ResponseEntity<Responsestructure<Address>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for address");
		}
	}
	
	public ResponseEntity<Responsestructure<Address>> getAddressbyid(int aid) {
		Address address=addressdao.getAddressbyid(aid);
		if (address!=null) {
			Responsestructure<Address> responsestructure=new Responsestructure<Address>();
			responsestructure.setMessage("Successfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(address);
			
			return new ResponseEntity<Responsestructure<Address>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
