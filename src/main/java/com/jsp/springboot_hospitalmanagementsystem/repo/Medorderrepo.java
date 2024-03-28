package com.jsp.springboot_hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Medorder;

public interface Medorderrepo extends JpaRepository<Medorder, Integer> {

}
