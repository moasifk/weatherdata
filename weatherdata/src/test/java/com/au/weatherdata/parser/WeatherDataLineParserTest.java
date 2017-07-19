package com.au.weatherdata.parser;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.au.weatherdata.model.WeatherDataLine;
import com.au.weatherdata.reader.WeatherDataLineReaderTest;

public class WeatherDataLineParserTest {

	final static Logger LOGGER = Logger.getLogger(WeatherDataLineParserTest.class);
	
	@Test
	public void testParseLine() {
		LineParser<WeatherDataLine> parser = new WeatherDataLineParser();
		WeatherDataLine weatherDataLine = parser.parseLine("SYD,-33.86,151.21,39,highest,42.1,39.8,33.9,30.0,26.9,25.9,31.3,34.6,38.2,41.8,42.2,45.8");
		WeatherDataLineReaderTest testReader = new WeatherDataLineReaderTest();
		assertTrue(testReader.getExpectedDataLineObject().equals(weatherDataLine));
		LOGGER.info(weatherDataLine.toString());
	}
}
