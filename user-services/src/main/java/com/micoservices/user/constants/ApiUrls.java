package com.micoservices.user.constants;

public class ApiUrls {
	private ApiUrls() {}

	public static final String URL_SEPERATOR = "/";
	public static final String API = "api";
	public static final String VERSION = "v1";
	public static final String BASE = URL_SEPERATOR + API + URL_SEPERATOR + VERSION + URL_SEPERATOR;

	// DY Parameters
	public static final String DY_USER_ID = URL_SEPERATOR + "{userId}";

	// Employee Api URL's
	public static final String BASE_USER = BASE + "users";
}
