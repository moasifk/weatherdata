package com.au.weatherdata.reader;

import java.io.IOException;

public interface WeatherDataReader<T> {
	
	public T readLine() throws IOException;

}
