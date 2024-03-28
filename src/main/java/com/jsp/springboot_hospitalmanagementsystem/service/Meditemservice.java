package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Meditemdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Meditems;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

import sun.security.mscapi.CKeyPairGenerator.RSA;

@Service
public class Meditemservice {

	@Autowired
	private Meditemdao meditemdao;
	
	public ResponseEntity<Responsestructure<Meditems>> saveMeditems(Meditems meditems,int id) {
		Responsestructure<Meditems> responsestructure=new Responsestructure<Meditems>();
		responsestructure.setMessage("Successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(meditemdao.saveMeditems(meditems, id));
		
		return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Meditems>> updateMeditems(int id,Meditems meditems) {
		Meditems meditems2=meditemdao.getMeditemsbyid(id);
		meditems.setMedorder(meditems2.getMedorder());
		
		Meditems dbMeditems=meditemdao.updateMeditems(id, meditems);
		if (dbMeditems!=null) {
			Responsestructure<Meditems> responsestructure=new Responsestructure<Meditems>();
			responsestructure.setMessage("Successfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(dbMeditems);
			
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for meditems");
		}
	}
	
	public ResponseEntity<Responsestructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems=meditemdao.deleteMeditems(id);
		if (meditems!=null) {
			Responsestructure<Meditems> responsestructure=new Responsestructure<Meditems>();
			responsestructure.setMessage("Successfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(meditems);
			
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for meditems");
		}
	}
	
	public ResponseEntity<Responsestructure<Meditems>> getMeditemsbyid(int id) {
		Meditems meditems=meditemdao.getMeditemsbyid(id);
		if (meditems!=null) {
			Responsestructure<Meditems> responsestructure=new Responsestructure<Meditems>();
			responsestructure.setMessage("Successfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(meditems);
			
			return new ResponseEntity<Responsestructure<Meditems>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
