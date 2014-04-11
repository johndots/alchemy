package ie.alchemytours.alchemytours;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.GpsStatus.NmeaListener;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class TakeTour1 extends Activity implements /*OnMarkerClickListener,*/OnInfoWindowClickListener {

	private static final int GPS_ERRORDIALOG_REQUEST = 9001;
	private GoogleMap mMap;
	static final LatLng MOLLY = new LatLng(53.343364,-6.259378);
	static final LatLng JJ = new LatLng(53.349796,-6.259979);
	static final LatLng Oscar = new LatLng(53.341098,-6.250733);
	static final LatLng OConnell = new LatLng(53.347721,-6.2594);
	static final LatLng Guinness = new LatLng(53.343602,-6.289117);
	
	
	
	
	
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (servicesOK()) {
			Toast.makeText(this, "Let's Go!!", Toast.LENGTH_SHORT).show();
			setContentView(R.layout.activity_map);
			mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
			        .getMap();
			mMap.setMyLocationEnabled(true);
			//mMap.setOnMarkerClickListener((OnMarkerClickListener) this);
			
			mMap.setOnInfoWindowClickListener(this);
			


			Marker molly = mMap.addMarker(new MarkerOptions()
	        .position(MOLLY)
	        .title("Molly Malone")
	        .snippet("Molly Malone was built 1926 by Dublin  City Council,\n She was a fish mongerer")
	        .snippet("Molly Malone was built 1926 by Dublin  City Council,\n She was a fish mongerer"));
			
			Marker jj = mMap.addMarker(new MarkerOptions()
	        .position(JJ)
	        .title("James Joyce")
	        .snippet("the James Joyce Statue was built 1926 by Dublin  City Council,\n\n She was a fish mongerer"));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
			
			Marker oscar = mMap.addMarker(new MarkerOptions()
	        .position(Oscar)
	        .title("Oscar Wilde")
	        
	        .snippet("the Oscar Wilde Statue was built 1926 by Dublin  City Council,\n\n "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
			Marker oconnell = mMap.addMarker(new MarkerOptions()
	        .position(OConnell)
	        .title("Daniel O Connell")
	        .snippet("the Daniel O Connell Statue was built 1926 by Dublin  City Council,\n\n "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
		Marker guinness = mMap.addMarker(new MarkerOptions()
	        .position(Guinness)
	        .title("Guinness")
	        .snippet("THE BLACK STUFF - Guinness is Ireland's top selling stout "));
			//mMap.showInfoWindow();
			mMap.setMyLocationEnabled(true);
			
			
		
			
			
			
			
			
			
			
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

	@Override
	public void onInfoWindowClick(Marker guinness) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(i);
		
	}
	



}