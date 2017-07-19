package com.au.weatherdata.model;

public class WeatherDataAdjacentDetails {
	
	private int preVal;
	
	private int currVal;
	
	private int nextVal;
	
	public WeatherDataAdjacentDetails(int pre, int curr, int next){
		this.preVal = pre;
		this.currVal = curr;
		this.nextVal = next;
	}
	
	public int getPreVal() {
		return preVal;
	}

	public void setPreVal(int preVal) {
		this.preVal = preVal;
	}

	public int getCurrVal() {
		return currVal;
	}

	public void setCurrVal(int currVal) {
		this.currVal = currVal;
	}

	public int getNextVal() {
		return nextVal;
	}

	public void setNextVal(int nextVal) {
		this.nextVal = nextVal;
	}
	
}
