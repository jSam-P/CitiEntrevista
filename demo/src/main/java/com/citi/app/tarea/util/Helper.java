package com.citi.app.tarea.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Helper {
	
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
}
