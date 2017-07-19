package com.au.weatherdata.parser;

public interface LineParser<T> {
	
	public T parseLine(String line);

}
