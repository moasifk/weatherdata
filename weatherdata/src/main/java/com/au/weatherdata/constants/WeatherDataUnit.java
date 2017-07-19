package com.au.weatherdata.constants;

/**
 * @author Asif
 * WeatherDataUnit enum value to extract the unit information
 * from the weather data line as highest/lowest.
 */
public enum WeatherDataUnit {
	HIGHEST, LOWEST;
	
	public static WeatherDataUnit getUnit(String str) {
		switch (str.toLowerCase()) {
		case "highest":
			return HIGHEST;
		case "lowest":
			return LOWEST;
		default:
			return null;
		}
	}
}
