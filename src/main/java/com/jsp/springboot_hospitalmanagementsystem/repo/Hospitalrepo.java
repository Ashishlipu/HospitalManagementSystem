package com.jsp.springboot_hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot_hospitalmanagementsystem.dto.Hospital;

public interface Hospitalrepo extends JpaRepository<Hospital, Integer> {

	@Query("select h from Hospital h where h.email=?1")
	public Hospital findbyemail(String email);
}
