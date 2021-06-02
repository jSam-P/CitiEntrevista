package com.citi.app.tarea.controllers.service;

import java.lang.invoke.MethodHandles;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class HeaderServiceImpl implements HeaderService {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass() );

	@Override
	public Map<String, List<String> > listarHeaders(HttpServletRequest request) {
		logger.info("listarHeaders():: inicia metodo");
		Map<String, List<String>> map = new HashMap<>();
		
		enumerationToStream(request.getHeaderNames()).forEach(k -> {
			List<String> lista = enumerationToStream(request.getHeaders(k)).collect(Collectors.toList());
			map.put(k, lista);
		});
		
		return map;
	}
	
	@Override
	public Map<String, List<String>> listarSelectedHeaders(HttpServletRequest request, List<String> headerNames) {
		logger.info("listarSelectedHeaders():: inicia metodo");
		Map<String, List<String>> map = new HashMap<>();
		
		List<String> headersList  = enumerationToStream(request.getHeaderNames())
		    		.filter(f-> headerNames.contains(f)).collect(Collectors.toList());
		
		headersList.stream().forEach(k -> {
			List<String> lista = enumerationToStream(request.getHeaders(k)).collect(Collectors.toList());
			map.put(k, lista);
		});
		
		return map;
	}

	
	 public static <T> Stream<T> enumerationToStream(Enumeration<T> enumeration) {
	        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new Iterator<T>() {
	            @Override
	            public T next() {
	                return enumeration.nextElement();
	            }

	            @Override
	            public boolean hasNext() {
	                return enumeration.hasMoreElements();
	            }

	            public void forEachRemaining(Consumer<? super T> action) {
	                while (enumeration.hasMoreElements())
	                    action.accept(enumeration.nextElement());
	            }
	        }, Spliterator.ORDERED), false);
	    }

	 
	 public List<Integer> removerDuplicados(List<Integer> numeros) {
		 
		 return numeros.stream().distinct().collect(Collectors.toList());
	}
}
