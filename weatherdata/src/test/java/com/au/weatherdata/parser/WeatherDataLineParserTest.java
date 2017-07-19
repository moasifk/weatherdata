package com.au.weatherdata.parser;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataLine;

public class WeatherDataLineParserTest {

	final static Logger LOGGER = Logger.getLogger(WeatherDataLineParserTest.class);
	
	public void testParseLine() {
		LineParser<WeatherDataLine> parser = new WeatherDataLineParser();
		WeatherDataLine weatherDataLine = parser.parseLine("SYD,-33.86,151.21,39,highest,42.1,39.8,33.9,30.0,26.9,25.9,31.3,34.6,38.2,41.8,42.2,45.8");
		LOGGER.info(weatherDataLine.toString());
	}
}
