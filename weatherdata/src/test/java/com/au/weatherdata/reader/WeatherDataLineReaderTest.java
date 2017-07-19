package com.au.weatherdata.reader;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataLine;
import com.au.weatherdata.parser.WeatherDataLineParser;


/**
 * @author Asif
 * Test case for readLine method to read the line from the input file
 * and to parse the line to WeatherDataLine object
 */
public class WeatherDataLineReaderTest {
	private final static Logger LOGGER = Logger.getLogger(WeatherDataLineReaderTest.class);
	
	@Test
	public void testReadLine() {
		WeatherDataLine dataLineActual;
		
		// Creation of expected data line.
		WeatherDataLine dataLineExpected = new WeatherDataLine();
		String location="SYD";
		float latitude=Float.valueOf((float) -33.86), longitude=Float.valueOf((float) 151.21);
		int elevation=39;
		WeatherDataUnit unit=WeatherDataUnit.HIGHEST;
		int janVal=4210, febVal=3980, marVal=3390, aprVal=3000, mayVal=2690, junVal=2590, 
			julVal=3130, augVal=3459, sepVal=3820, octVal=4180, novVal=4220, decVal=4580;
		dataLineExpected.setLocation(location);
		dataLineExpected.setLatitude(latitude);
		dataLineExpected.setLongitude(longitude);
		dataLineExpected.setElevation(elevation);
		dataLineExpected.setUnit(unit);
		dataLineExpected.setJanVal(janVal);
		dataLineExpected.setFebVal(febVal);
		dataLineExpected.setMarVal(marVal);
		dataLineExpected.setAprVal(aprVal);
		dataLineExpected.setMayVal(mayVal);
		dataLineExpected.setJunVal(junVal);
		dataLineExpected.setJulVal(julVal);
		dataLineExpected.setAugVal(augVal);
		dataLineExpected.setSepVal(sepVal);
		dataLineExpected.setOctVal(octVal);
		dataLineExpected.setNovVal(novVal);
		dataLineExpected.setDecVal(decVal);
		
		try {
			dataLineActual = new WeatherDataLineReader(new WeatherDataLineParser(), new File("items.txt")).readLine();
			assertTrue(dataLineActual.equals(dataLineExpected));
			LOGGER.info("testReadLine completed.");
		} catch (IOException e) {
			LOGGER.error("Error occured while parsing the line."+e.getMessage());
		}
	}
}
