package com.au.weatherdata.parser;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataLine;

/*
 * Class for parsing the input line to its 
 * corresponding fields.
 */
public class WeatherDataLineParser implements LineParser<WeatherDataLine> {

	final static Logger LOGGER = Logger.getLogger(WeatherDataLineParser.class);
	
	/* 
	 * Parse input line to WeatherDataLine object
	 */
	@Override
	public WeatherDataLine parseLine(String line) {
		List<String> lineItems = Arrays.asList(line.split(","));
		final int numberOfTokens = lineItems.size();
		if (numberOfTokens < 17) {
			return null;
		}
		final WeatherDataLine weatherDataLine = new WeatherDataLine();
		final String location = lineItems.get(0);
		try {
			final float latitude = Float.valueOf(lineItems.get(1));
			final WeatherDataUnit unit = WeatherDataUnit.getUnit(lineItems.get(4));
			if (unit == null)
				return null;

			weatherDataLine.setLocation(location.toUpperCase());
			weatherDataLine.setLatitude(latitude);
			weatherDataLine.setLongitude(Float.valueOf(lineItems.get(2)));
			weatherDataLine.setElevation(Integer.valueOf(lineItems.get(3)));
			weatherDataLine.setUnit(unit);
			weatherDataLine.setJanVal((int) (Float.valueOf(lineItems.get(5)) * 100));
			weatherDataLine.setFebVal((int) (Float.valueOf(lineItems.get(6)) * 100));
			weatherDataLine.setMarVal((int) (Float.valueOf(lineItems.get(7)) * 100));
			weatherDataLine.setAprVal((int) (Float.valueOf(lineItems.get(8)) * 100));
			weatherDataLine.setMayVal((int) (Float.valueOf(lineItems.get(9)) * 100));
			weatherDataLine.setJunVal((int) (Float.valueOf(lineItems.get(10)) * 100));
			weatherDataLine.setJulVal((int) (Float.valueOf(lineItems.get(11)) * 100));
			weatherDataLine.setAugVal((int) (Float.valueOf(lineItems.get(12)) * 100));
			weatherDataLine.setSepVal((int) (Float.valueOf(lineItems.get(13)) * 100));
			weatherDataLine.setOctVal((int) (Float.valueOf(lineItems.get(14)) * 100));
			weatherDataLine.setNovVal((int) (Float.valueOf(lineItems.get(15)) * 100));
			weatherDataLine.setDecVal((int) (Float.valueOf(lineItems.get(16)) * 100));
		} catch (Exception e) {
			LOGGER.info("One Item in csv file format is not valid. The name of this Item is "
					+ location + ":" + lineItems.get(2) + "/n " + e.getMessage());
			return null;
		}
		return weatherDataLine;
	}
	
}
