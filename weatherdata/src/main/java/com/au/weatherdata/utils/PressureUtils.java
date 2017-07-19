package com.au.weatherdata.utils;
/**
 * The <code>PressureUtils</code> class represents the all pressure operations  
 * 
 * @author <a href="mailto:jingyuzhang2008@gmail.com">Jingyu ZHANG</a>
 * @version  1.0
 * @since May 2016
 **/
public class PressureUtils {
	public static int getPressure (){
		return 1000 + RadomRange.randInt(0, 300) -150;
	}
}
