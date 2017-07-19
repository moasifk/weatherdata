package com.au.weatherdata.utils;

public class HumidityUtils {
	public static int getHumidity( String condition){
		switch (condition) {
		case "Rain":
			return RadomGenerator.getRandInt(80, 97);
		case "Snow":
			return RadomGenerator.getRandInt(50, 70);
		default:
			return RadomGenerator.getRandInt(20, 40);
		}
	}
}
