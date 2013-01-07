package com.alten.restclient;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.alten.restclient.infrastructure.LocationData;
import com.alten.restclient.infrastructure.LocationObject;

public class MainActivity extends FragmentActivity {

	private ArrayAdapter<LocationData> locationAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        //setContentView(R.layout.activity_rest_service);
        
        locationAdapter = new LocationAdapter(this, R.layout.item_label_list, new ArrayList<LocationData>());
        
       FragmentManager     fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        // Since we are using the Android Compatibility library
        // we have to use FragmentActivity. So, we use ListFragment
        // to get the same functionality as ListActivity.
        ListFragment list = new ListFragment();
        ft.add(R.id.fragment_content, list);
        
        // Let's set our list adapter to a simple ArrayAdapter.
        list.setListAdapter(locationAdapter);
        
        // RESTResponderFragments call setRetainedInstance(true) in their onCreate() method. So that means
        // we need to check if our FragmentManager is already storing an instance of the responder.
        LocationListResponderFragment responder = (LocationListResponderFragment) fm.findFragmentByTag("RESTResponder");
        if (responder == null) {
            responder = new LocationListResponderFragment();
            
            // We add the fragment using a Tag since it has no views. It will make the Twitter REST call
            // for us each time this Activity is created.
            ft.add(responder, "RESTResponder");
        }

        // Make sure you commit the FragmentTransaction or your fragments
        // won't get added to your FragmentManager. Forgetting to call ft.commit()
        // is a really common mistake when starting out with Fragments.
        ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public ArrayAdapter<LocationData> getLocationAdapter()
	{
		return this.locationAdapter;
	}

}
