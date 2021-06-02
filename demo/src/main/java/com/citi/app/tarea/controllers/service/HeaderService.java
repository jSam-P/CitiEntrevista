package com.citi.app.tarea.controllers.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface HeaderService {

	public Map<String, List<String>> listarHeaders(HttpServletRequest request);

	public Map<String, List<String>> listarSelectedHeaders(HttpServletRequest request, List<String> headerNames);
}
