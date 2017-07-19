package com.au.weatherdata.driver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.au.weatherdata.constants.WeatherDataUnit;
import com.au.weatherdata.model.WeatherData;
import com.au.weatherdata.model.WeatherDataAdjacentDetails;
import com.au.weatherdata.reader.WeatherDataReader;

public class WeatherDataModel<T extends WeatherData> {
	
	Map<String, Map<Integer, Map<WeatherDataUnit, WeatherDataAdjacentDetails>>> weatherModel = new HashMap<>();
	
	private final WeatherDataReader<T> reader;
	
	public WeatherDataModel(WeatherDataReader<T> reader) {
		this.reader = reader;
		loadWeatherData();
	}
	
	private void loadWeatherData() {
		
		T line;
		while ((line = readNextLine()) != null) {
			Map<Integer, Map<WeatherDataUnit, WeatherDataAdjacentDetails>> locationMap = null;
			Map<WeatherDataUnit, WeatherDataAdjacentDetails> featureMap = null; 
			String key = line.getLocation() + "|" + line.getLatitude() + ","
					+ line.getLongitude() + "," + line.getElevation();
			if (!weatherModel.containsKey(key)) {
				weatherModel.put(key,
						new HashMap<Integer, Map<WeatherDataUnit, WeatherDataAdjacentDetails>>());
			}
			locationMap = weatherModel.get(key);
			// Jan
			if (!locationMap.containsKey(1)) {
				locationMap.put(1, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(1).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getDecVal(), line.getJanVal(), line
							.getFebVal()));
			// Feb
			if (!locationMap.containsKey(2)) {
				locationMap.put(2, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(2).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getJanVal(), line.getFebVal(), line
							.getMarVal()));
			// March
			if (!locationMap.containsKey(3)) {
				locationMap.put(3, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(3).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getFebVal(), line.getMarVal(), line
							.getAprVal()));

			// Apri
			if (!locationMap.containsKey(4)) {
				locationMap.put(4, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(4).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getMarVal(), line.getAprVal(), line
							.getMayVal()));

			// May
			if (!locationMap.containsKey(5)) {
				locationMap.put(5, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(5).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getAprVal(), line.getMayVal(), line
							.getJunVal()));
			// June
			if (!locationMap.containsKey(6)) {
				locationMap.put(6, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(6).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getMayVal(), line.getJunVal(), line
							.getJulVal()));
			// July
			if (!locationMap.containsKey(7)) {
				locationMap.put(7, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(7).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getJunVal(), line.getJulVal(), line
							.getAugVal()));
			// Aug
			if (!locationMap.containsKey(8)) {
				locationMap.put(8, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(8).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getJulVal(), line.getAugVal(), line
							.getSepVal()));
			// Sep
			if (!locationMap.containsKey(9)) {
				locationMap.put(9, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(9).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getAugVal(), line.getSepVal(), line
							.getOctVal()));
			// Oct
			if (!locationMap.containsKey(10)) {
				locationMap.put(10, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(10).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getSepVal(), line.getOctVal(), line
							.getNovVal()));
			// Nov
			if (!locationMap.containsKey(11)) {
				locationMap.put(11, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(11).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getOctVal(), line.getNovVal(), line
							.getDecVal()));
			// Dec
			if (!locationMap.containsKey(12)) {
				locationMap.put(12, new HashMap<WeatherDataUnit, WeatherDataAdjacentDetails>());
			}
			locationMap.get(12).put(
					line.getUnit(),
					new WeatherDataAdjacentDetails(line.getNovVal(), line.getDecVal(), line
							.getJanVal()));

		}
		
	}
	
	public T readNextLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException("Read line error", e);
		}
	}
	
	public Map<String, Map<Integer, Map<WeatherDataUnit, WeatherDataAdjacentDetails>>> getModel() {
		return weatherModel;
	}
}