package com.alten.restclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.alten.restclient.infrastructure.LocationObject;

public class MainActivity extends Activity {

	private ArrayAdapter<LocationObject> locationAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public ArrayAdapter<LocationObject> getLocationAdapter()
	{
		return this.locationAdapter;
	}

}
