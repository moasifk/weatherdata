package com.au.weatherdata.utils;

import java.util.Random;

public class RadomGenerator {
	public static int getRandInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
