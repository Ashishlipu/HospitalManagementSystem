package com.jsp.springboot_hospitalmanagementsystem.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.springboot_hospitalmanagementsystem.util.Responsestructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Idnotfound.class)
	public ResponseEntity<Responsestructure<String>> idnotfound(Idnotfound ex) {
		Responsestructure<String> responsestructure=new Responsestructure<String>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData("Id not found");
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestructure<String>> nosuchelement(NoSuchElementException ex){
		Responsestructure<String> responsestructure=new Responsestructure<String>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData("no element found");
		
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> list=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<String, String>();
		for (ObjectError error : list) {
			String fieldname=((FieldError)error).getField();
			String message=((FieldError)error).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Responsestructure<String>> handleConstraintViolationException(ConstraintViolationException ex) {
		Responsestructure<String> responsestructure=new Responsestructure<String>();
		responsestructure.setMessage(ex.getMessage());
		responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestructure.setData("this field should not be null or blank");
		
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.BAD_REQUEST);
	}
}
