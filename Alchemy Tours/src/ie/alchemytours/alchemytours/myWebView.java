package ie.alchemytours.alchemytours;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class myWebView extends WebViewClient {
	@Override
	
	public boolean shouldOverrideUrlLoading(WebView v, String Url){
		
		v.loadUrl(Url);
		return true;
	}

}
