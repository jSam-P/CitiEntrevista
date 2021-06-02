package com.citi.app.tarea.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.app.tarea.service.HeaderService;

@RestController
@RequestMapping("/start")
public class HeaderController {	
	
	@Autowired
	private HeaderService headerService;
	
	/**
	 * Obtiene los headers de HttpServletRequest 
	 * 
	 * @param request
	 * @return
	 */	
	@GetMapping(path = "/getHeaders")
	public ResponseEntity<Map<String, List<String>>> getHeaders(HttpServletRequest request){
		
		Map<String, List<String>> map = headerService.getHeaders(request);

		return new ResponseEntity<Map<String,List<String>>>(map,HttpStatus.OK);
	}
	
	/**
	 * Obtiene lo headers especificos de HttpServletRequest
	 * 
	 * @param request
	 * @param headerNames
	 * @return
	 */
	
	@GetMapping(path = "/getSelectedHeaders")
	public ResponseEntity<Map<String, List<String>>> getSelectedHeaders(HttpServletRequest request, 
			@RequestParam List<String> headerNames){
		
		Map<String, List<String>> map = headerService.getSelectedHeaders(request, headerNames);

		return new ResponseEntity<Map<String,List<String>>>(map,HttpStatus.OK);
	}

	/**
	 * Remueve elementos duplicados de la lista.
	 * 
	 * @param numbers
	 * @return
	 */
	@GetMapping(path = "/removeDuplicates")
	public ResponseEntity<List<Integer>> removeDuplicates(@RequestParam(required = true) List<Integer> numbers){
		
		return new ResponseEntity<List<Integer>>(headerService.removeDuplicates(numbers),HttpStatus.OK);
	}
	
}
