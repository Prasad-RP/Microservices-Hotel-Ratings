package com.micoservices.hotel.utils;

import static java.util.Collections.emptyList;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.of;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CollectionUtil {
	private CollectionUtil() {

	}

	/**
	 * 
	 * @param <T>
	 * @param collection
	 * @return
	 */
	public static <T> List<T> newList(Collection<T> collection) {
		if (Objects.isNull(collection) || collection.isEmpty())
			return Collections.emptyList();
		return collection.stream().toList();
	}

	/**
	 * 
	 * @param <T>
	 * @param elements
	 * @return
	 */
	@SafeVarargs
	public static <T> List<T> newList(T... elements) {
		return isNull(elements) || elements.length == 0 ? emptyList()
				: of(elements).collect(toCollection(ArrayList::new));
	}
}
