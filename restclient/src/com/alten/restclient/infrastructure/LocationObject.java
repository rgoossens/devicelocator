package com.alten.restclient.infrastructure;


public class LocationObject 
{
	private int deviceid;
	private String message;
	private long timeStamp;
	private double lat;
	private double lon;
	private double alt;
	
	public int getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	
	public LocationObject(int deviceid, String message, long timeStamp, double lat,
			double lon, double alt) 
	{
		super();
		this.deviceid = deviceid;
		this.message = message;
		this.timeStamp = timeStamp;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}
	
	public LocationObject()
	{
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LocationObject other = (LocationObject) obj;
		if (deviceid != other.deviceid) {
			return false;
		}
		return true;
	}
	
	
	

}
