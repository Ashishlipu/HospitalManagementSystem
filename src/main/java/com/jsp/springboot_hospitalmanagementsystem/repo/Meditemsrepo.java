package com.jsp.springboot_hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Meditems;

public interface Meditemsrepo extends JpaRepository<Meditems, Integer> {

}
