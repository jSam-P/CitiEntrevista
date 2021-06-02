package com.citi.app.tarea.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.app.tarea.controllers.service.HeaderService;

@RestController
public class HeaderController {	
	
	@Autowired
	HeaderService headerService;
	
	@GetMapping("/getHeaders")
	public ResponseEntity<Map<String, List<String>>> getHeaders(HttpServletRequest request){
		
		Map<String, List<String>> map = headerService.listarHeaders(request);

		return new ResponseEntity<Map<String,List<String>>>(map,HttpStatus.OK);
	}
	
	@GetMapping("/getSelectedHeaders")
	public ResponseEntity<Map<String, List<String>>> getSelectedHeaders(HttpServletRequest request, 
			@RequestParam List<String> headerNames){
		
		Map<String, List<String>> map = headerService.listarSelectedHeaders(request, headerNames);

		return new ResponseEntity<Map<String,List<String>>>(map,HttpStatus.OK);
	}

	
}
