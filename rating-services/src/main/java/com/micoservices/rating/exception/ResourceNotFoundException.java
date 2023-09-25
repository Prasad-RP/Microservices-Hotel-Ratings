package com.micoservices.rating.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Prasad Pansare
 *
 */
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String resourceName;
	String fieldName;
	String userId;

	public ResourceNotFoundException(String resourceName, String fieldName, String userId) {
		super(String.format("%s not found on server with %s : %s", resourceName, fieldName, userId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.userId = userId;
	}

	public ResourceNotFoundException(String resourceName, String userId) {
		super(String.format("%s not found on server with : %s", resourceName, userId));
		this.resourceName = resourceName;
		this.userId = userId;
	}

}
