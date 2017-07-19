package com.au.weatherdata.driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataAdjacentDetails;
import com.au.weatherdata.utils.DateUtils;
import com.au.weatherdata.utils.HumidityUtils;
import com.au.weatherdata.utils.PressureUtils;
import com.au.weatherdata.utils.RainfallUtils;
import com.au.weatherdata.utils.RadomGenerator;

/**
 * @author Asif
 * This is the Generator class for generating the weather data from 
 * a start date to a particular duration and saved it in an output path
 */
public class WeatherGenerator {
	final static Logger LOGGER = Logger.getLogger(WeatherGenerator.class);
	
	WeatherDataModel<?> baseModel;

	public WeatherGenerator(WeatherDataModel<?> model) {
		this.baseModel = model;
	}
	
	
	/**
	 * @param startdate startdate to generate the weather data
	 * @param duration to which to generate the weather data
	 * @param path output path for the generated data
	 * @return
	 */
	public boolean generateData(String startdate, int duration, String path) {
		
		String dateString = startdate;
		Calendar currentDate = DateUtils.getCalendar(dateString);
        // Creating output file
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				LOGGER.error("Error on create file:");
				System.exit(1);
			}
		}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < duration; i++) {
				int currentMonth = currentDate.get(Calendar.MONTH) + 1;
				int dayOfMonth = 30;
				int currentDay = currentDate.get(Calendar.DATE);

				for (int j = 0; j < 3; j++) {
					for (Entry<String, Map<Integer, Map<WeatherDataUnit, WeatherDataAdjacentDetails>>> entry : baseModel
							.getModel().entrySet()) {
						Map<WeatherDataUnit, WeatherDataAdjacentDetails> value = entry.getValue()
								.get(currentMonth);
						int currentMax, currentMin, preMax, maxAvg, preMin, nextMax, nextMin, minAvg, dailyMax, dailyMin = 0;
						double  temperature = 0.0;
						String time = "";
						currentMax = value.get(WeatherDataUnit.HIGHEST).getCurrVal();
						preMax = value.get(WeatherDataUnit.HIGHEST).getPreVal();
						nextMax = value.get(WeatherDataUnit.HIGHEST).getNextVal();
						maxAvg = (currentMax + preMax + nextMax) / 3;
						
						currentMin = value.get(WeatherDataUnit.LOWEST).getCurrVal();
						preMin = value.get(WeatherDataUnit.LOWEST).getPreVal();
						nextMin = value.get(WeatherDataUnit.LOWEST).getNextVal();
						minAvg = (currentMin + preMin + nextMin) / 3;
						
						if (currentDay <= dayOfMonth / 2) {
							dailyMax = RadomGenerator.getRandInt(
									(preMax < maxAvg)?preMax:maxAvg, (preMax > maxAvg)?preMax:maxAvg);
							dailyMin = RadomGenerator.getRandInt(
									(preMin < minAvg)?preMin:minAvg, (preMin > minAvg)?preMin:minAvg);
						} else {
							dailyMax = RadomGenerator.getRandInt(
									(nextMax < maxAvg)?nextMax:maxAvg, (nextMax > maxAvg)?nextMax:maxAvg);
							dailyMin = RadomGenerator.getRandInt(
									(nextMin < minAvg)?nextMin:minAvg, (nextMin > minAvg)?nextMin:minAvg);
						}
						if (j == 0) {
							temperature = dailyMin/100;
							time = "T01:22:" + RadomGenerator.getRandInt(10, 30) + "Z";
						} else if (j == 1) {
							temperature = dailyMax/100;
							time = "T12:50:" + RadomGenerator.getRandInt(30, 45) + "Z";
						} else if (j == 2) {
							temperature = (dailyMin + (dailyMax - dailyMin) / 2)/100;
							time = "T18:22:" + RadomGenerator.getRandInt(45, 59) + "Z";
						}
//						String tempStr = String.format("%.1f", temperature).toString();
						String conditions = RainfallUtils.checkCondition(
								currentMonth, temperature);
						bw.write((new StringBuffer())
								.append(entry.getKey())
								.append("|")
								.append(DateUtils.getDateStringFromCalendar(currentDate))
								.append(time).append("|").append(conditions)
								.append("|").append(temperature).append("|")
								.append(PressureUtils.getPressure())
								.append("|")
								.append(HumidityUtils.getHumidity(conditions))
								.toString());
						bw.newLine();
					}
				}
			}
		} catch(Exception e) {
			
		}
		return false;
		
	}
}
