package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Medorderdao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Medorderservice {

	@Autowired
	private Medorderdao medorderdao;
	
	public ResponseEntity<Responsestructure<Medorder>> saveMedorder(Medorder medorder,int eid) {
		Responsestructure<Medorder> responsestructure=new Responsestructure<Medorder>();
		responsestructure.setMessage("Successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(medorderdao.saveMedorder(medorder, eid));
		
		return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Medorder>> updateMedorder(Medorder medorder,int mid) {
		Medorder medorder2=medorderdao.getMedorderbyid(mid);
		medorder.setEncounter(medorder2.getEncounter());
		
		Medorder medorder3=medorderdao.updateMedorder(mid, medorder);
		if (medorder3!=null) {
			Responsestructure<Medorder> responsestructure=new Responsestructure<Medorder>();
			responsestructure.setMessage("Successfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(medorder3);
			
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for medorder");
		}
	}
	
	public ResponseEntity<Responsestructure<Medorder>> deleteMedorder(int mid) {
		Medorder medorder=medorderdao.deleteMedorder(mid);
		if (medorder!=null) {
			Responsestructure<Medorder> responsestructure=new Responsestructure<Medorder>();
			responsestructure.setMessage("Successfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(medorder);
			
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for medorder");
		}
	}
	
	public ResponseEntity<Responsestructure<Medorder>> getMedorderbyid(int mid) {
		Medorder medorder=medorderdao.getMedorderbyid(mid);
		if (medorder!=null) {
			Responsestructure<Medorder> responsestructure=new Responsestructure<Medorder>();
			responsestructure.setMessage("Successfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(medorder);
			
			return new ResponseEntity<Responsestructure<Medorder>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
