package ie.alchemytours.alchemytours;


 
//import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
//import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
/*
 * Demo of creating an application to open any URL inside the application and clicking on any link from that URl
should not open Native browser but  that URL should open in the same screen.
 */
public class BookTour extends Activity {
    /** Called when the activity is first created. */
 
    WebView web;
 
    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_tour);
 
        web = (WebView) findViewById(R.id.webview01);
       // web = new WebView(this);
        web.setWebViewClient(new myWebClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://alchemytours.ie/bookc.php");
        web.getSettings().setLoadWithOverviewMode(true);
        web.getSettings().setUseWideViewPort(true);
    }
 
    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }
 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
 
            view.loadUrl(url);
            return true;
 
        }
    }
 
    // To handle "Back" key press event for WebView to go back to previous screen.
/*   @Override
   public boolean onKeyDown(int keyCode, KeyEvent event)
  {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
        web.goBack();
        return true;
    }
    return super.onKeyDown(keyCode, event);
   }*/
   @Override
   public void onBackPressed() {
      super.onBackPressed();
if (web.getUrl().contains("http://www.alchemytours.ie/thankyou1.php?")){
       
       Intent i = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(i);
}
else if (web.getUrl().contains("http://alchemytours.ie/bookc.php")){
    
    Intent i = new Intent(getApplicationContext(),MainActivity.class);
		startActivity(i);
}

else{Intent i = new Intent(getApplicationContext(),BookTour.class);
startActivity(i);}
   }
}


/*
 * simpler
 * create web view in layout
 * 
 * 
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
 
public class WebViewActivity extends Activity {
 
	private WebView webView;
 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
 
		webView = (WebView) findViewById(R.id.webView1);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://www.google.com");
 
	}
 
}
*/








/*package ie.alchemytours.alchemytours;


import android.os.Bundle;
import android.webkit.WebView;

import android.app.Activity;


public class BookTour extends Activity{
	private WebView mWebview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_tour);
	//	mWebview.setWebViewClient(new myWebView());
		mWebview = new WebView(this);
        mWebview.loadUrl("http://letsorder.host-ed.me/alchemy/form.html");
       // mWebview.loadUrl("http://letsorder.host-ed.me/alchemy/form.html");
        //http://www.youtube.com/watch?v=6fOCoJuc4Qs
        setContentView(mWebview);

		
	}
	

}*/