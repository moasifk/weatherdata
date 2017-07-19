package com.au.weatherdata;

import java.io.File;

import org.apache.log4j.Logger;

import com.au.weatherdata.driver.WeatherDataModel;
import com.au.weatherdata.driver.WeatherGenerator;
import com.au.weatherdata.model.WeatherDataLine;
import com.au.weatherdata.parser.WeatherDataLineParser;
import com.au.weatherdata.reader.WeatherDataLineReader;


/**
 * Main class for the weather data generation
 * 
 * This is the entry class for the weather data generator.
 * Here all the data from the inputData file is read and parsed 
 * and placed in a HashMap having value as inner HashMap.
 * Once the data is parsed and created a DataModel, the required 
 * weather data is generated and written to a output file
 * @author Asif
 */
public class WeatherDataGen 
{
	private final static Logger LOGGER = Logger.getLogger(WeatherDataGen.class);
	
    public static void main( String[] args )
    {
    	if (args == null | args.length < 4) {
			LOGGER.error("Require 4 parameters. \n"
					+ "startdate duration outputpath");
			System.exit(1);
		}
    	try {
    		// Initializing WeatherDataLineReader with LineParser and input path
    		WeatherDataLineReader dataLineReader = new WeatherDataLineReader(new WeatherDataLineParser(), new File(args[0]));
    		// Creation of weatherDataModel with the datalineReader. This will create the datamodel 
    		// with all data from the input file
    		WeatherDataModel<WeatherDataLine> weatherDataModel = new WeatherDataModel<WeatherDataLine>(dataLineReader);
    		// Initializing the weatherGenerator
    		WeatherGenerator weatherGenerator = new WeatherGenerator(weatherDataModel);
    		String startDate = args[1];
			int duration = Integer.parseInt(args[2]);
			String outputPath = args[3];
			weatherGenerator.generateData(startDate, duration,outputPath);
    	} catch(Exception e) {
    		
    	}
    }
}
