package com.jsp.springboot_hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Encounter;

public interface Encounterrepo extends JpaRepository<Encounter, Integer> {

}
