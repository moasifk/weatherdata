package com.au.weatherdata.model;

import com.au.weatherdata.constants.WeatherDataUnit;

/**
 * @author Asif
 * WeatherData implementation for the data line from the 
 * input csv file
 */
public class WeatherDataLine implements WeatherData {
	
	private String location;
	
	private float latitude;
	
	private float longitude;
	
	private int elevation;
	
	private WeatherDataUnit unit;
	
	private int janVal;
	
	private int febVal;
	
	private int marVal;
	
	private int aprVal;
	
	private int mayVal;
	
	private int junVal;
	
	private int julVal;
	
	private int augVal;
	
	private int sepVal;
	
	private int octVal;
	
	private int novVal;
	
	private int decVal;

	public String getLocation() {
		return location;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public int getElevation() {
		return elevation;
	}

	public WeatherDataUnit getUnit() {
		return unit;
	}

	public int getJanVal() {
		return janVal;
	}

	public int getFebVal() {
		return febVal;
	}

	public int getMarVal() {
		return marVal;
	}

	public int getAprVal() {
		return aprVal;
	}

	public int getMayVal() {
		return mayVal;
	}

	public int getJunVal() {
		return junVal;
	}

	public int getJulVal() {
		return julVal;
	}

	public int getAugVal() {
		return augVal;
	}

	public int getSepVal() {
		return sepVal;
	}

	public int getOctVal() {
		return octVal;
	}

	public int getNovVal() {
		return novVal;
	}

	public int getDecVal() {
		return decVal;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public void setUnit(WeatherDataUnit unit) {
		this.unit = unit;
	}

	public void setJanVal(int janVal) {
		this.janVal = janVal;
	}

	public void setFebVal(int febVal) {
		this.febVal = febVal;
	}

	public void setMarVal(int marVal) {
		this.marVal = marVal;
	}

	public void setAprVal(int aprVal) {
		this.aprVal = aprVal;
	}

	public void setMayVal(int mayVal) {
		this.mayVal = mayVal;
	}

	public void setJunVal(int junVal) {
		this.junVal = junVal;
	}

	public void setJulVal(int julVal) {
		this.julVal = julVal;
	}

	public void setAugVal(int augVal) {
		this.augVal = augVal;
	}

	public void setSepVal(int sepVal) {
		this.sepVal = sepVal;
	}

	public void setOctVal(int octVal) {
		this.octVal = octVal;
	}

	public void setNovVal(int novVal) {
		this.novVal = novVal;
	}

	public void setDecVal(int decVal) {
		this.decVal = decVal;
	}

	@Override
	public String toString() {
		return "WeatherData [location=" + location + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", elevation=" + elevation + ", unit=" + unit + ", janVal=" + janVal + ", febVal=" + febVal
				+ ", marVal=" + marVal + ", aprVal=" + aprVal + ", mayVal=" + mayVal + ", junVal=" + junVal
				+ ", julVal=" + julVal + ", augVal=" + augVal + ", sepVal=" + sepVal + ", octVal=" + octVal
				+ ", novVal=" + novVal + ", decVal=" + decVal + "]";
	}
	
}
