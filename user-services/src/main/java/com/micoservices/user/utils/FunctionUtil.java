package com.micoservices.user.utils;

import static java.util.Objects.isNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class FunctionUtil {

	private FunctionUtil() {
	}

	private static final ModelMapper mapper = new ModelMapper();

	static {
		mapper.getConfiguration().setAmbiguityIgnored(true);
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * This method will take any object and class. map object to passed class type
	 * and return.
	 * 
	 * @param <T>
	 * @param obj
	 * @param clazz
	 * @return Map fields of passed object to passed class
	 * @since version 1.0
	 */
	public static <T> Optional<T> evalMapper(Object obj, Class<T> clazz) {
		return isNull(obj) || isNull(clazz) ? Optional.empty() : Optional.of(mapper.map(obj, clazz));
	}

	public static <C, T> Collection<T> evalMapperCollection(Collection<C> list, Class<T> clazz) {
		if (isNull(list) || isNull(clazz) || list.isEmpty())
			return Collections.emptyList();
		return list.stream().map(e -> evalMapper(e, clazz)).filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toList());
	}
}
