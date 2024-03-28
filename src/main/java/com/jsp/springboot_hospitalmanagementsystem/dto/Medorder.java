package com.jsp.springboot_hospitalmanagementsystem.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Medorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	
//	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@NotBlank(message="doctor cannot be null or blank")
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;
}
