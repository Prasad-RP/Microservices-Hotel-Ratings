package com.micoservices.hotel.enums;

public enum ApiKey {

	MESSAGE("Message"), SUCCESS("Success"), DATA("Data"), TOKEN("Token");

	String value;

	private ApiKey(String value) {
		this.value = value;
	}

	public String val() {
		return value;
	}

}
