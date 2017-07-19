package com.au.weatherdata.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.au.weatherdata.model.WeatherDataLine;
import com.au.weatherdata.parser.LineParser;

public class WeatherDataLineReader implements WeatherDataReader<WeatherDataLine> {

	private final static Logger LOGGER = Logger.getLogger(WeatherDataLineReader.class);
	
	private BufferedReader bufferedReader;
	private final LineParser<WeatherDataLine> parser;
	
	/**
	 * @param parser Any implementation of Lineparser
	 * @param file 
	 * @throws IOException
	 * WeatherDataLineReader constructor with parser and file arguments.
	 */
	public WeatherDataLineReader(LineParser<WeatherDataLine> parser, File file) throws IOException {
		if (file == null) {
			LOGGER.error("File is null");
			throw new NullPointerException("The file can't be null");
		}
		if (!file.exists()) {
			LOGGER.error("File doesn't exist: ");
			throw new IOException("File doesn't exist: "
					+ file.getAbsolutePath());
		}
		if (!file.canRead()) {
			LOGGER.error("Can't read file. ");
			throw new IOException("Can't read file: " + file.getAbsolutePath());
		}
		this.parser = parser;
		this.bufferedReader = new BufferedReader(new FileReader(file));
		
	}
	
	/* 
	 * An implementation for readLine.
	 * This method reads the line from the file and parse it to WeatherData object.
	 */
	public WeatherDataLine readLine() throws IOException {
		if (this.bufferedReader == null) {
			return null;
		}
		String line = this.bufferedReader.readLine();
		while (line != null) {
			WeatherDataLine temp = parser.parseLine(line);
			if (temp != null) {
				LOGGER.info("Line parsed successfully");
				return temp;
			}
			line = this.bufferedReader.readLine();
		}
		close();
		return null;
	}
	
	public void close() throws IOException {
		this.bufferedReader.close();
		this.bufferedReader = null;
	}
	
}
