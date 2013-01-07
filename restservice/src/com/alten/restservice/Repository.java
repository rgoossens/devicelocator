package com.alten.restservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repository 
{
	private static Repository instance;
	
	
	private List<Location> locations;
	
	private Repository()
	{
		this.locations = new ArrayList<Location>();
		this.locations.add(new Location(1,"Test",new Date().getTime(),51,6,50));
		this.locations.add(new Location(2,"Test 2",new Date().getTime(),51,6,50));
		this.locations.add(new Location(3,"Test 3",new Date().getTime(),51,6,50));
		this.locations.add(new Location(4,"Test 3",new Date().getTime(),51,6,50));
		this.locations.add(new Location(5,"Test 3",new Date().getTime(),51,6,50));
		this.locations.add(new Location(6,"Test 3",new Date().getTime(),51,6,50));
		this.locations.add(new Location(7,"Test 3",new Date().getTime(),51,6,50));
	}
	
	public void updateLocation(Location location)
	{
		int existingIndex = locations.indexOf(location);
		if (existingIndex == -1)
		{
			this.locations.add(location);
		}
		else
		{
			Location existingLocation = locations.get(existingIndex);
			existingLocation = location;
		}
	}
	
	public List<Location> getLocations()
	{
		return this.locations;
	}
	
	
	
	public static Repository getInstance()
	{
		if (instance== null)
		{
			instance = new Repository();
		}
		
		return instance;
	}

}
