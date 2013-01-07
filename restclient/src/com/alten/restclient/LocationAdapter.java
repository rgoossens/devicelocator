package com.alten.restclient;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alten.restclient.infrastructure.LocationData;

public class LocationAdapter extends ArrayAdapter<LocationData> 
{

	private int resId;


	public LocationAdapter(Context context, int textViewResourceId,
			List<LocationData> objects) 
	{
		super(context, textViewResourceId, objects);

		this.resId = textViewResourceId;
	} 

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View row = convertView;
		PositionHolder holder = null;
		
		if (row == null)
		{
			LayoutInflater inflater = ((Activity)this.getContext()).getLayoutInflater();
			row = inflater.inflate(this.resId, parent, false);
			
            holder = new PositionHolder();           
            holder.txtDeviceId = (TextView)row.findViewById(R.id.txtDeviceId);
            holder.txtTimeStamp = (TextView)row.findViewById(R.id.txtTimeStamp);
            holder.txtLat = (TextView)row.findViewById(R.id.txtLat);
            holder.txtLon = (TextView)row.findViewById(R.id.txtLon);
            holder.txtAltitude = (TextView)row.findViewById(R.id.txtAltitude);
            holder.txtMessage = (TextView)row.findViewById(R.id.txtMessage);
           
            row.setTag(holder);
        }
        else
        {
            holder = (PositionHolder)row.getTag();
        }
       
        LocationData location = this.getItem(position);
        holder.txtDeviceId.setText("" + location.getDeviceid());
        holder.txtTimeStamp.setText("" + location.getTimeStamp());        
        holder.txtLat.setText("" + location.getLat());
        holder.txtLon.setText("" +location.getLon());
        holder.txtAltitude.setText("" + location.getAlt());
        holder.txtMessage.setText(location.getMessage());
      
       
        return row;
    }
		
	
	
	
	static class PositionHolder
	{
		TextView txtDeviceId;
		TextView txtLat;
		TextView txtLon;
		TextView txtTimeStamp;
		TextView txtAltitude;
		TextView txtMessage;
	}
	

}
