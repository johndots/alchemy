package ie.alchemytours.alchemytours;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

import android.widget.Button;

public class MainActivity extends Activity {
	
	Button button_about;
	Button button_take_tour;
	Button button_availability;
	Button button_book_tour;
	Button button_buy_full_version;
	Button button_scan;
	Button button_nfc;
	WebView w;
	
	//public class myWebViewClient extends WebViewClient {
	   // @Override
	 //   public boolean shouldOverrideUrlLoading(WebView view, String url) {
	   //     view.loadUrl(url);
	   // true;
	//   }
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_new);
		
		button_about = (Button) findViewById(R.id.button_about);
		button_take_tour = (Button) findViewById(R.id.button_take_tour);
		button_availability = (Button) findViewById(R.id.button_availability);
		button_book_tour = (Button) findViewById(R.id.button_book_tour);
		button_buy_full_version= (Button) findViewById(R.id.button_buy_full_version);
		button_scan= (Button) findViewById(R.id.button_scan);
		button_nfc = (Button)findViewById(R.id.button_nfc);
		
		
		button_about.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),About.class);
				startActivity(i);
				
			}
		});
		
		button_take_tour.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),TakeTour2.class);
				startActivity(i);
				
			}
		});
		
	button_availability.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Statues.class);
				startActivity(i);
				
			}
		});
		
	button_book_tour.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),BookTour.class);
				startActivity(i);
				
			}
		});
		
	button_buy_full_version.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.theopen.android"));
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=me.zed_0xff.android.alchemy&hl=en"));
				startActivity(intent);

				
			}
		});
	
	button_nfc.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),NFC.class);
			startActivity(i);
			
		}
	});
	
	button_scan.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),DemoActivity.class);
			startActivity(i);
			
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
