package com.jsp.springboot_hospitalmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Encounter;
import com.jsp.springboot_hospitalmanagementsystem.repo.Encounterrepo;

@Repository
public class Encounterdao {

	@Autowired
	private Encounterrepo encounterrepo;

	public Encounter saveEncounter(Encounter encounter) {
		return encounterrepo.save(encounter);
	}

	public Encounter updatEncounter(int eid, Encounter encounter) {
		if (encounterrepo.findById(eid).isPresent()) {
			encounter.setEid(eid);
			return encounterrepo.save(encounter);
		} else {
			return null;
		}
	}

	public Encounter deletEncounterbyid(int eid) {
		if (encounterrepo.findById(eid).isPresent()) {
			Encounter encounter = encounterrepo.findById(eid).get();
			encounterrepo.deleteById(eid);
			return encounter;
		} else {
			return null;
		}
	}

	public Encounter getEncounterbyid(int eid) {
		if (encounterrepo.findById(eid).isPresent()) {
			Encounter encounter = encounterrepo.findById(eid).get();
			return encounter;
		} else {
			return null;
		}
	}
}
