package com.jsp.springboot_hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Encounter;
import com.jsp.springboot_hospitalmanagementsystem.dto.Medorder;
import com.jsp.springboot_hospitalmanagementsystem.repo.Medorderrepo;

@Repository
public class Medorderdao {

	@Autowired
	private Medorderrepo medorderrepo;

	@Autowired
	private Encounterdao encounterdao;

	public Medorder saveMedorder(Medorder medorder, int eid) {
		Encounter encounter = encounterdao.getEncounterbyid(eid);
		medorder.setEncounter(encounter);
		return medorderrepo.save(medorder);
	}

	public Medorder updateMedorder(int mid, Medorder medorder) {
		if (medorderrepo.findById(mid).isPresent()) {
			medorder.setMid(mid);
			return medorderrepo.save(medorder);
		} else {
			return null;
		}
	}

	public Medorder deleteMedorder(int mid) {
		if (medorderrepo.findById(mid).isPresent()) {
			Medorder medorder = medorderrepo.findById(mid).get();
			medorderrepo.deleteById(mid);
			return medorder;
		} else {
			return null;
		}
	}

	public Medorder getMedorderbyid(int mid) {
		if (medorderrepo.findById(mid).isPresent()) {
			Medorder medorder=medorderrepo.findById(mid).get();
			return medorder;
	    }else {
		   return null;
	    }
	}
}
