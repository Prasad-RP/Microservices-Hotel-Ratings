package com.micoservices.user.utils;

import java.util.Random;

public class StringUtils {

	public static String generateRandomHotelName() {
		String HotelName = "HTL";
		Random random = new Random();
		return HotelName + random.nextInt(10000);
	}

	public static String generateRandomUserName() {
		String UserName = "USR";
		Random random = new Random();
		return UserName + random.nextInt(10000);
	}
}
