package com.micoservices.user.utils;

import static java.util.Objects.isNull;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for json object conversions.
 * 
 * @author Prasad Pansare
 *
 */
public class JsonUtils {
	private JsonUtils() {
	}

	public static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @param clazz
	 * @return Object of given class.
	 */
	public static <T> T convertJsonToObject(Object jsonObject, Class<T> clazz) {
		return isNull(jsonObject) || isNull(clazz) ? null : objectMapper.convertValue(jsonObject, clazz);
	}

	/**
	 * 
	 * @param <T>
	 * @param jsonObject
	 * @param clazz
	 * @return List of given class
	 */
	public static <T> List<T> convertJsonToList(Object jsonObject, Class<T> clazz) {
		return isNull(jsonObject) || isNull(clazz) ? Collections.emptyList()
				: objectMapper.convertValue(jsonObject,
						objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
	}
}
