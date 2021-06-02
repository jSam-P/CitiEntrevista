package com.citi.app.tarea.service;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.citi.app.tarea.util.Helper.enumerationToStream;

@Service
public class HeaderServiceImpl implements HeaderService {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Obtiene un Map de los headers de HttpServletRequest
	 */
	@Override
	public Map<String, List<String>> getHeaders(HttpServletRequest request) {
		logger.info("getHeaders():: inicia metodo");
		Map<String, List<String>> map = new HashMap<>();

		enumerationToStream(request.getHeaderNames())
				.forEach(k -> map.put(k, enumerationToStream(request.getHeaders(k)).collect(Collectors.toList())));

		return map;
	}

	/**
	 * Obtiene un Map filtrado con los headers indicados.
	 */
	@Override
	public Map<String, List<String>> getSelectedHeaders(HttpServletRequest request, List<String> headerNames) {
		logger.info("getSelectedHeaders():: inicia metodo");
		Map<String, List<String>> map = new HashMap<>();

		enumerationToStream(request.getHeaderNames()).filter(f -> headerNames.contains(f))
				.forEach(k -> map.put(k, enumerationToStream(request.getHeaders(k)).collect(Collectors.toList())));
		return map;
	}

	/**
	 * Devuelve los elementos distintos de una lista.
	 */
	@Override
	public List<Integer> removeDuplicates(List<Integer> numeros) {
		logger.info("removeDuplicates():: inicia metodo");
		return numeros.stream().distinct().collect(Collectors.toList());
	}
}
