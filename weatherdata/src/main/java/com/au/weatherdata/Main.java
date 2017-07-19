package com.au.weatherdata;

import java.io.File;
import java.util.logging.Logger;

import com.au.weatherdata.driver.WeatherDataModel;
import com.au.weatherdata.driver.WeatherGenerator;
import com.au.weatherdata.model.WeatherDataLine;
import com.au.weatherdata.parser.WeatherDataLineParser;
import com.au.weatherdata.reader.WeatherDataLineReader;


public class Main 
{
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
    public static void main( String[] args )
    {
    	if (args == null | args.length < 4) {
			LOGGER.severe("parameters are not enough, Main.class required 5 parameters. Two Absolute Paths.\n"
					+ " One is the file cotains row data that will put in Model, another is the Alerts file.\n"
					+ " a start date, a duration, and a outputPath.\n"
					+ "e.g.  java -cp waetherdata.jar Main items.txt 2016-06-20 30 output.txt"
					);
			System.exit(1);
		}
    	try {
    		WeatherDataLineReader dataLineReader = new WeatherDataLineReader(new WeatherDataLineParser(), new File(args[0]));
    		WeatherDataModel<WeatherDataLine> weatherDataModel = new WeatherDataModel<WeatherDataLine>(dataLineReader);
    		WeatherGenerator weatherGenerator = new WeatherGenerator(weatherDataModel);
    		String startDate = args[1];
			int duration = Integer.parseInt(args[2]);
			String outputPath = args[3];
			weatherGenerator.generateData(startDate, duration,outputPath);
    	} catch(Exception e) {
    		
    	}
    }
}
