package com.au.weatherdata.utils;
/**
 * The <code>HumidityUtils</code> class represents the all humidity operations  
 * 
 * @author <a href="mailto:jingyuzhang2008@gmail.com">Jingyu ZHANG</a>
 * @version  1.0
 * @since May 2016
 **/
public class HumidityUtils {
	public static int getHumidity( String condition){
		switch (condition) {
		case "Rain":
			return RadomRange.randInt(80, 97);
		case "Snow":
			return RadomRange.randInt(50, 70);
		default:
			return RadomRange.randInt(20, 40);
		}
	}
}
