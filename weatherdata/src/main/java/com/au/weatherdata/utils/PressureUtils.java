package com.au.weatherdata.utils;

public class PressureUtils {
	public static int getPressure (){
		return 1000 + RadomGenerator.getRandInt(0, 300) -150;
	}
}
