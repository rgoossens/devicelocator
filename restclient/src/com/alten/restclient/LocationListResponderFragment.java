package com.alten.restclient;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.alten.restclient.infrastructure.LocationData;
import com.alten.restclient.infrastructure.LocationObject;
import com.alten.restclient.infrastructure.RestConsumer;
import com.alten.restclient.infrastructure.RestResponderFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LocationListResponderFragment extends RestResponderFragment {

	private LocationObject locations;
	
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        // This gets called each time our Activity has finished creating itself.
        updateList();
    }

	@Override
	public void onRESTResult(int code, String result) 
	{
		MainActivity activity = (MainActivity)this.getActivity();
		if (code != 200 || result == null)
		{
            if (activity != null) 
            {
                Toast.makeText(activity, "Failed to load location data. Check your internet settings.", Toast.LENGTH_SHORT).show();
            }
		}
		else
		{
			//Deserialize json
			Gson gson = new Gson();
			Type collectionType = new TypeToken<Collection<LocationObject>>(){}.getType();
			this.locations = gson.fromJson(result, LocationObject.class);
			
		
			updateList();
		}
			
			
		
		

	}
	
	private void updateList()
	{
		MainActivity activity = (MainActivity)this.getActivity();
		
		if (activity != null)
		{
			if (locations == null)
			{
				//No data loaded yet, so execute REST call
				 Intent intent = new Intent(activity, RestConsumer.class);
		         intent.setData(Uri.parse("http://192.168.1.22:8080/RESTService/rest/"));
		         intent.putExtra(RestConsumer.EXTRA_RESULT_RECEIVER, getResultReceiver());
		         activity.startService(intent);
			}
						
			if (locations != null && locations.getLocationData() != null)
			{
			//Let activity display the data (TODO: maybe this fragment can be extended to even display
			//stuff)
			ArrayAdapter<LocationData> adapter = activity.getLocationAdapter();
			adapter.clear();
			
			for (LocationData obj : this.locations.getLocationData())
			{
				adapter.add(obj);
			}
			}
			
		
		}
	}

}
