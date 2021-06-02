package com.citi.app.tarea.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface HeaderService {

	public Map<String, List<String>> getHeaders(HttpServletRequest request);

	public Map<String, List<String>> getSelectedHeaders(HttpServletRequest request, List<String> headerNames);
	
	public List<Integer> removeDuplicates(List<Integer> numeros);
}
