package com.au.weatherdata.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.au.weatherdata.parser.LineParser;

public class WeatherDataLineReader<T> implements WeatherDataReader<T> {

	private BufferedReader bufferedReader;
	private final LineParser<T> parser;
	
	public WeatherDataLineReader(LineParser parser, File file) throws IOException{
		if (file == null)
			throw new NullPointerException("The file can't be null");
		if (!file.exists())
			throw new IOException("File doesn't exist: "
					+ file.getAbsolutePath());
		if (!file.canRead())
			throw new IOException("Can't read file: " + file.getAbsolutePath());
		this.parser = parser;
		this.bufferedReader = new BufferedReader(new FileReader(file));
		
	}
	
	public T readLine() throws IOException {
		if (this.bufferedReader == null) {
			return null;
		}
		String line = this.bufferedReader.readLine();
		while (line != null) {
			T temp = parser.parseLine(line);
			if (temp != null)
				return temp;
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
