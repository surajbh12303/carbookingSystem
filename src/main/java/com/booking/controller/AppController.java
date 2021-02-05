package com.booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/")
public class AppController {
	
	@GetMapping(value = "hello")
	public ResponseEntity<String> greet(){
		return ResponseEntity.status(HttpStatus.OK).body("hello");
		
	}

}
