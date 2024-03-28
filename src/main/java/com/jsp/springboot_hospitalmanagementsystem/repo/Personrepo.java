package com.jsp.springboot_hospitalmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_hospitalmanagementsystem.dto.Person;

public interface Personrepo extends JpaRepository<Person, Integer> {

}
