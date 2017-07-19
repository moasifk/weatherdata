package com.au.weatherdata.parser;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataLine;

public class WeatherDataLineParser implements LineParser<WeatherDataLine> {

	private final static Logger LOGGER = Logger.getLogger(WeatherDataLineParser.class.getName());
	
	@Override
	public WeatherDataLine parseLine(String line) {
		List<String> lineItems = Arrays.asList(line.split(","));
		final int numberOfTokens = lineItems.size();
		if (numberOfTokens < 17) {
			return null;
		}
		final WeatherDataLine result = new WeatherDataLine();
		final String location = lineItems.get(0);
		try {
			final float latitude = Float.valueOf(lineItems.get(1));
			final WeatherDataUnit unit = WeatherDataUnit.getUnit(lineItems.get(4));
			if (unit == null)
				return null;

			result.setLocation(location.toUpperCase());
			result.setLatitude(latitude);
			result.setLongitude(Float.valueOf(lineItems.get(2)));
			result.setElevation(Integer.valueOf(lineItems.get(3)));
			result.setUnit(unit);
			result.setJanVal((int) (Float.valueOf(lineItems.get(5)) * 100));
			result.setFebVal((int) (Float.valueOf(lineItems.get(6)) * 100));
			result.setMarVal((int) (Float.valueOf(lineItems.get(7)) * 100));
			result.setAprVal((int) (Float.valueOf(lineItems.get(8)) * 100));
			result.setMayVal((int) (Float.valueOf(lineItems.get(9)) * 100));
			result.setJunVal((int) (Float.valueOf(lineItems.get(10)) * 100));
			result.setJulVal((int) (Float.valueOf(lineItems.get(11)) * 100));
			result.setAugVal((int) (Float.valueOf(lineItems.get(12)) * 100));
			result.setSepVal((int) (Float.valueOf(lineItems.get(13)) * 100));
			result.setOctVal((int) (Float.valueOf(lineItems.get(14)) * 100));
			result.setNovVal((int) (Float.valueOf(lineItems.get(15)) * 100));
			result.setDecVal((int) (Float.valueOf(lineItems.get(16)) * 100));
		} catch (Exception e) {
			LOGGER.severe("One Item in csv file format is not valid. The name of this Item is "
					+ location + ":" + lineItems.get(2) + "/n " + e.getMessage());
			return null;
		}
		return result;
	}
	
}
