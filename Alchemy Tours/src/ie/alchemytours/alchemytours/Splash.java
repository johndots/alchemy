package ie.alchemytours.alchemytours;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;





public class Splash extends Activity {

	
	@Override
	protected void onCreate(Bundle splash_screen) {
		// TODO Auto-generated method stub
		super.onCreate(splash_screen);
		setContentView(R.layout.splash);
		
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}finally{ 
					Intent openStartingPoint = new Intent("ie.alchemytours.alchemytours.MainActivity");
					
					startActivity(openStartingPoint);
					finish();
					
				}
			}
		};
		timer.start();
		
		
		
	}

	

}