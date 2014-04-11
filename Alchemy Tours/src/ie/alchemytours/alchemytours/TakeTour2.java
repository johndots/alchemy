package ie.alchemytours.alchemytours;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.MapFragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.GpsStatus.NmeaListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TakeTour2 extends Activity implements /*OnMarkerClickListener,*/OnInfoWindowClickListener {

	private static final int GPS_ERRORDIALOG_REQUEST = 9001;
	private GoogleMap mMap;
	static final LatLng MOLLY = new LatLng(53.343364,-6.259378);
	static final LatLng JJ = new LatLng(53.349796,-6.259979);
	static final LatLng Oscar = new LatLng(53.341098,-6.250733);
	static final LatLng OConnell = new LatLng(53.347721,-6.2594);
	static final LatLng Guinness = new LatLng(53.343602,-6.289117);
	RadioButton lit;
	RadioButton his;
	RadioButton all;
	RadioGroup RG;
	//Button map_button;
	LocationManager lm;
	 double lat=53.341098,long1=-6.259979;
	 float radius=30000; 
	

	
	

	
	
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (servicesOK()) {
			Toast.makeText(this, "Let's Go!!", Toast.LENGTH_SHORT).show();
			setContentView(R.layout.activity_map);
			
			//-----------------------------------
			lm=(LocationManager) getSystemService(LOCATION_SERVICE);
	        Intent i= new Intent (getApplicationContext(),About.class);
			      //Custom Action
	        PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), -1, i, 0);
	        lm.addProximityAlert(lat, long1, radius, -1, pi);
	        
	        
	     // Instantiates a new Polyline object and adds points to define a rectangle
	        PolylineOptions rectOptions = new PolylineOptions()
	                .add(new LatLng(53.343364,-6.259378))
	                .add(new LatLng(37.45, -122.0))  // North of the previous point, but at the same longitude
	                .add(new LatLng(37.45, -122.2))  // Same latitude, and 30km to the west
	                .add(new LatLng(37.35, -122.2))  // Same longitude, and 16km to the south
	                .add(new LatLng(53.343364,-6.259378)); // Closes the polyline.

	       
	        
	        
	        
			//-----------------------------------
			
			
			
			
			
			mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
			        .getMap();
			mMap.setMyLocationEnabled(true);
			//mMap.setOnMarkerClickListener((OnMarkerClickListener) this);
			
			mMap.setOnInfoWindowClickListener(this);
			mMap.getUiSettings().setMyLocationButtonEnabled(true);
			CameraPosition cameraPosition = new CameraPosition.Builder().target(
	                MOLLY).zoom(14).build();
	 
	mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	//map_button= (Button) findViewById(R.id.map_button);
	his =(RadioButton) findViewById(R.id.radio_historical);
	lit =(RadioButton) findViewById(R.id.radio_literary);
	all =(RadioButton) findViewById(R.id.all);
	RG = (RadioGroup) findViewById(R.id.rg);

/*	public void onRadioButtonClicked(View view) {
	
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.radio_historical:
	            if (checked)
	            	molly.setVisible(false);
	            break;
	        case R.id.radio_literary:
	            if (checked)
	            	molly.setVisible(true);
	            break;
	    }
	}
	*/


			final Marker molly = mMap.addMarker(new MarkerOptions()
	        .position(MOLLY)
	        .title("Molly Malone")
	        .snippet("Molly Malone was built 1926 by Dublin  City Council,\n She was a fish mongerer"));
			//molly.setVisible(false);
			molly.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
			
			
			

			
			
			
		/*	map_button.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					
					molly.setVisible(true);
				}
			});
			*/
			
		
			
			
final Marker jj = mMap.addMarker(new MarkerOptions()
	        .position(JJ)
	        .title("James Joyce")
	        .snippet("the James Joyce Statue was built 1926 by Dublin  City Council,\n\n She was a fish mongerer"));
			//mMap.showInfoWindow();
jj.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
			
			
			
			final Marker oscar = mMap.addMarker(new MarkerOptions()
	        .position(Oscar)
	        .title("Oscar Wilde")
	        
	        .snippet("the Oscar Wilde Statue was built 1926 by Dublin  City Council,\n\n "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
			final Marker oconnell = mMap.addMarker(new MarkerOptions()
	        .position(OConnell)
	        .title("Daniel O Connell")
	        .snippet("the Daniel O Connell Statue was built 1926 by Dublin  City Council,\n\n "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
		final Marker guinness = mMap.addMarker(new MarkerOptions()
	        .position(Guinness)
	        .title("Guinness")
	        .snippet("THE BLACK STUFF - Guinness is Ireland's top selling stout "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
lit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					
					molly.setVisible(true);
					jj.setVisible(true);
					oscar.setVisible(false);
					oconnell.setVisible(false);
					guinness.setVisible(false);
				}
			});
			
his.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		molly.setVisible(false);
		jj.setVisible(false);
		oscar.setVisible(true);
		oconnell.setVisible(true);
		guinness.setVisible(true);
	}
});
all.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		molly.setVisible(true);
		jj.setVisible(true);
		oscar.setVisible(true);
		oconnell.setVisible(true);
		guinness.setVisible(true);
	}
});
			
		
			
			
			
			
			
			
			
		}
		else{setContentView(R.layout.activity_main_new);}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean servicesOK() {
		int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		
		if (isAvailable == ConnectionResult.SUCCESS) {
			return true;
		}
		else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, GPS_ERRORDIALOG_REQUEST);
			dialog.show();
		}
		else {
			Toast.makeText(this, "Can't connect to Google Play services", Toast.LENGTH_SHORT).show();
		}
		return false;
	}

/*

	@Override
	public boolean onMarkerClick(Marker marker) {
		// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(),About.class);
		startActivity(i);
		return false;
	}
	*/
	/*
	@Override
	public void onInfoWindowClick(Marker guinness) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(i);
		
	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		 if(arg0.getTitle().equals("Guinness")){ // if marker source is clicked
			 Intent i = new Intent(getApplicationContext(),MainActivity.class);
			startActivity(i);
        

	}
		return true;
	
	}
	*/
	@Override
	public void onInfoWindowClick(Marker arg0) {
		 if(arg0.getTitle().equals("Guinness")){ // if marker source is clicked
			 Intent i = new Intent(getApplicationContext(),Youtube.class);
			startActivity(i);

	}
		 else{Intent i = new Intent(getApplicationContext(),Video.class);
			startActivity(i);}
		
	
	}


}