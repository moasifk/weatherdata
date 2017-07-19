package com.au.weatherdata.driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherDataAdjacentDetails;
import com.au.weatherdata.utils.DatetimeUtils;
import com.au.weatherdata.utils.HumidityUtils;
import com.au.weatherdata.utils.PressureUtils;
import com.au.weatherdata.utils.RadomRange;
import com.au.weatherdata.utils.RainfallUtils;

public class WeatherGenerator {
	
	WeatherDataModel<?> baseModel;

	public WeatherGenerator(WeatherDataModel<?> model) {
		this.baseModel = model;
	}
	
	public boolean generateData(String startdate, int duration, String path) {
		
		String dateString = startdate;
		Calendar currentDate = DatetimeUtils.getCalendar(dateString);
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error on create file:");
				e.printStackTrace();
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
						int currentMax, currentMin, preMax, preMin, nextMax, nextMin, dailyMax, dailyMin, temperature = 0;
						String time = "";
						currentMax = value.get(WeatherDataUnit.HIGHEST).getCurrVal();
						preMax = value.get(WeatherDataUnit.HIGHEST).getPreVal();
						nextMax = value.get(WeatherDataUnit.HIGHEST).getNextVal();

						currentMin = value.get(WeatherDataUnit.LOWEST).getCurrVal();
						preMin = value.get(WeatherDataUnit.LOWEST).getPreVal();
						nextMin = value.get(WeatherDataUnit.LOWEST).getNextVal();

						int firstHalfIntervialMax = (preMax - currentMax)
								/ dayOfMonth;
						int firstHalfIntervialMin = (preMin - currentMin)
								/ dayOfMonth;

						int secondHalfIntervialMax = (currentMax - nextMax)
								/ dayOfMonth;
						int secondHalfIntervialMin = (currentMin - nextMin)
								/ dayOfMonth;

						if (currentDay <= dayOfMonth / 2) {
							dailyMax = preMax - firstHalfIntervialMax
									* (currentDay + dayOfMonth / 2);
							dailyMin = preMin - firstHalfIntervialMin
									* (currentDay + dayOfMonth / 2);
						} else {
							dailyMax = currentMax - secondHalfIntervialMax
									* (currentDay - dayOfMonth / 2);
							dailyMin = currentMin - secondHalfIntervialMin
									* (currentDay - dayOfMonth / 2);
						}
						if (j == 0) {
							temperature = dailyMin;
							time = "T01:22:" + RadomRange.randInt(10, 30) + "Z";
						} else if (j == 1) {
							temperature = dailyMax;
							time = "T12:50:" + RadomRange.randInt(30, 45) + "Z";
						} else if (j == 2) {
							temperature = dailyMin + (dailyMax - dailyMin) / 2;
							time = "T18:22:" + RadomRange.randInt(45, 59) + "Z";
						}
//						String tempStr = String.format("%.1f", temperature).toString();
						String conditions = RainfallUtils.checkCondition(
								currentMonth, temperature);
						bw.write((new StringBuffer())
								.append(entry.getKey())
								.append("|")
								.append(DatetimeUtils
										.getDateStringFromCalendar(currentDate))
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
