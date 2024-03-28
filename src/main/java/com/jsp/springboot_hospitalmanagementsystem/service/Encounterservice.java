package com.jsp.springboot_hospitalmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_hospitalmanagementsystem.dao.Branchdao;
import com.jsp.springboot_hospitalmanagementsystem.dao.Encounterdao;
import com.jsp.springboot_hospitalmanagementsystem.dao.Persondao;
import com.jsp.springboot_hospitalmanagementsystem.dto.Branch;
import com.jsp.springboot_hospitalmanagementsystem.dto.Encounter;
import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;
import com.jsp.springboot_hospitalmanagementsystem.dto.Person;
import com.jsp.springboot_hospitalmanagementsystem.exception.Idnotfound;
import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@Service
public class Encounterservice {

	@Autowired
	private Encounterdao encounterdao;
	
	@Autowired
	private Persondao persondao;
	
	@Autowired
	private Branchdao branchdao;

	public ResponseEntity<Responsestructure<Encounter>> saveEncounter(Encounter encounter,int pid,int bid) {
		Person person=persondao.getPersonbyid(pid);
		Branch branch=branchdao.getBranchbyid(bid);
		
		encounter.setPerson(person);
		List<Branch> list=new ArrayList<Branch>();
		list.add(branch);
		encounter.setList(list);
		
		Responsestructure<Encounter> responsestructure=new Responsestructure<Encounter>();
		responsestructure.setMessage("Successfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(encounterdao.saveEncounter(encounter));
		
		return new ResponseEntity<Responsestructure<Encounter>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Encounter>> updatEncounter(int eid,Encounter encounter,int bid) {
		Encounter encounter2=encounterdao.getEncounterbyid(eid);
		Branch branch=branchdao.getBranchbyid(bid);
		
		List<Branch> list=encounter2.getList();
		encounter.setList(list);
		encounter.setPerson(encounter2.getPerson());
		
		Responsestructure<Encounter> responsestructure=new Responsestructure<Encounter>();
		responsestructure.setMessage("Successsfully updated");
		responsestructure.setStatus(HttpStatus.OK.value());
		responsestructure.setData(encounterdao.updatEncounter(eid, encounter));
		
		return new ResponseEntity<Responsestructure<Encounter>>(responsestructure,HttpStatus.OK);
	}
	
	public ResponseEntity<Responsestructure<Encounter>> deletEncounter(int eid) {
		Encounter encounter=encounterdao.deletEncounterbyid(eid);
		if (encounter!=null) {
			Responsestructure<Encounter> responsestructure=new Responsestructure<Encounter>();
			responsestructure.setMessage("Successsfully deleted");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(encounter);
			
			return new ResponseEntity<Responsestructure<Encounter>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound("id not found for encounter");
		}
	}
	
	public ResponseEntity<Responsestructure<Encounter>> getEncounterbyid(int eid) {
		Encounter encounter=encounterdao.getEncounterbyid(eid);
		if (encounter!=null) {
			Responsestructure<Encounter> responsestructure=new Responsestructure<Encounter>();
			responsestructure.setMessage("Successsfully found");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(encounter);
			return new ResponseEntity<Responsestructure<Encounter>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new NoSuchElementException("no id found");
		}
	}
}
