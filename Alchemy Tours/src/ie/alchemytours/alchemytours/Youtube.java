package ie.alchemytours.alchemytours;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;
 
import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
 
public class Youtube extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {
 
	private ImageSwitcher imageSwitcher; Button btnNext;
	int imageIds[]={R.drawable.guinness1, R.drawable.guinness2, R.drawable.guinness3};
	int messageCount=imageIds.length;
	int currentIndex=-1;
	
	
    private YouTubePlayer YPlayer;
    private static final String YoutubeDeveloperKey = "AIzaSyB64xIpVZ54KKvBfmKvKJ-PIrNf_GOBWoE";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    
    
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
 
        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(YoutubeDeveloperKey, this);
        
        
        btnNext=(Button)findViewById(R.id.buttonNext);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewFactory() { public View makeView() {
        	
        	ImageView imageView = new ImageView(getApplicationContext());
        	imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        	//imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
        	return imageView; }
        });

         Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
         Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
         
         imageSwitcher.setInAnimation(in); imageSwitcher.setOutAnimation(out);
         btnNext.setOnClickListener(new View.OnClickListener() {
        	 public void onClick(View v) {
        		 currentIndex++;
        		 
        		 if(currentIndex==messageCount)
        			 
        			 currentIndex=0; imageSwitcher.setImageResource(imageIds[currentIndex]); } }); }
    
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
            YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YoutubeDeveloperKey, this);
        }
    }
 
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
 
    @Override
    public void onInitializationSuccess(Provider provider,
            YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            YPlayer = player;
            /*
             * Now that this variable YPlayer is global you can access it
             * throughout the activity, and perform all the player actions like
             * play, pause and seeking to a position by code.
             */
            YPlayer.cueVideo("ISf2YqFe9-I");
        }
    }
    
    
 
}
