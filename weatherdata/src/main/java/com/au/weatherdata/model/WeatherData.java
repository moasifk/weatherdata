package com.au.weatherdata.model;

import com.au.weatherdata.constants.WeatherDataUnit;

/**
 * @author Asif
 * 
 * WeatherDataLine interface which provides basic methods for 
 * to read data from the input weather data csv file. 
 *
 */
public interface WeatherData {
	
	
	public String getLocation();
	
	public float getLatitude();

	public float getLongitude();
	
	public int getElevation();
	
	public WeatherDataUnit getUnit();
	
	public int getJanVal();

	public int getFebVal();

	public int getMarVal();

	public int getAprVal();

	public int getMayVal();

	public int getJunVal();

	public int getJulVal();

	public int getAugVal();

	public int getSepVal();

	public int getOctVal();

	public int getNovVal();

	public int getDecVal();
	
}
