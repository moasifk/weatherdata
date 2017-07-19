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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aprVal;
		result = prime * result + augVal;
		result = prime * result + decVal;
		result = prime * result + elevation;
		result = prime * result + febVal;
		result = prime * result + janVal;
		result = prime * result + julVal;
		result = prime * result + junVal;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + marVal;
		result = prime * result + mayVal;
		result = prime * result + novVal;
		result = prime * result + octVal;
		result = prime * result + sepVal;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherDataLine other = (WeatherDataLine) obj;
		if (aprVal != other.aprVal)
			return false;
		if (augVal != other.augVal)
			return false;
		if (decVal != other.decVal)
			return false;
		if (elevation != other.elevation)
			return false;
		if (febVal != other.febVal)
			return false;
		if (janVal != other.janVal)
			return false;
		if (julVal != other.julVal)
			return false;
		if (junVal != other.junVal)
			return false;
		if (Float.floatToIntBits(latitude) != Float
				.floatToIntBits(other.latitude))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Float.floatToIntBits(longitude) != Float
				.floatToIntBits(other.longitude))
			return false;
		if (marVal != other.marVal)
			return false;
		if (mayVal != other.mayVal)
			return false;
		if (novVal != other.novVal)
			return false;
		if (octVal != other.octVal)
			return false;
		if (sepVal != other.sepVal)
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}
	
}
