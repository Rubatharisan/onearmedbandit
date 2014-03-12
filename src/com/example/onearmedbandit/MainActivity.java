package com.example.onearmedbandit;

import java.util.Timer;
import java.util.TimerTask;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	// AnimationDrawable declaration
	AnimationDrawable anim1, anim2, anim3;
	// ImageView declaration
	ImageView iv1, iv2, iv3;
	//MediaPlayer
	MediaPlayer mediaPlayer;
	// Bitmap declaration
	BitmapDrawable b1, b2, b3;
	// Toast declaration
	Toast toast;
	// Bet declaration
	int myBet = 0;
	//Object
	
SharedPreferences sp;
	
	//Timer Thread

private class Timer extends AsyncTask<Void, Void, Void>{

	protected Void doInBackground(Void...arg) {
		
		try {
			Thread.sleep(12000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void onPostExecute(Void arg){
		
		anim1.stop();
		anim2.stop();
		anim3.stop();
		b1 = (BitmapDrawable) anim1.getCurrent();
		b2 = (BitmapDrawable) anim2.getCurrent();
		b3 = (BitmapDrawable) anim3.getCurrent();

		AllStopped();
		
		Log.d("onPostExecute", "onPostExecute" );
		
		toast = Toast.makeText(MainActivity.this, "The game has stopped", 100000);
		toast.setGravity(Gravity.BOTTOM, 0, 0);
		toast.show();
	}
	
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        
        //Play sound
        mediaPlayer = MediaPlayer.create(MainActivity.this.getApplicationContext(), R.raw.play);
        
        //declaring and setting the 3 imageViews
        
        iv1 = (ImageView) findViewById(R.id.imageView1);
        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv3 = (ImageView) findViewById(R.id.imageView3);
        
        iv1.setBackgroundResource(R.animator.animlist1);
        iv2.setBackgroundResource(R.animator.animlist2);
        iv3.setBackgroundResource(R.animator.animlist3);
        
        anim1 = (AnimationDrawable) iv1.getBackground();
        anim2 = (AnimationDrawable) iv2.getBackground();
        anim3 = (AnimationDrawable) iv3.getBackground();
        
        
        
        //Button Start listener
        
        final Button bStart = (Button) findViewById(R.id.button4);
        
        bStart.setOnClickListener(new OnClickListener() {
        	
			
			@Override
			public void onClick(View v) {	
				
				
		            	anim1.start();
						anim2.start();
						anim3.start();		
						
						//Play Sound
						mediaPlayer.start();
						//start timer
						new Timer().execute();
						
					
				Toast toast = Toast.makeText(MainActivity.this, "The game has been started, use the stop buttons", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
				
			}
		});
        
        //Button Stop1 listener
        
        Button bStop1 = (Button) findViewById(R.id.button1);
        
        bStop1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim1.stop();
				b1 = (BitmapDrawable) anim1.getCurrent();
				
				AllStopped();
			}
		});
        
     // Button Stop2 listener
        
        Button bStop2 = (Button) findViewById(R.id.button2);
        
        bStop2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim2.stop();
				b2 = (BitmapDrawable) anim2.getCurrent();
				
				AllStopped();
			}
		});
        
        //Button Stop3 listener
        
        Button bStop3 = (Button) findViewById(R.id.button3);
        
        bStop3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim3.stop();
				b3 = (BitmapDrawable) anim3.getCurrent();
				
				AllStopped();
			}
		});
        
    }
    

    private void AllStopped() {
		// TODO Auto-generated method stub
    	myBet = Integer.parseInt(sp.getString("betPre",""));
    	
    	if(!anim1.isRunning() && !anim2.isRunning() && !anim3.isRunning()){
			if(b1.getBitmap().equals(b2.getBitmap()) && b2.getBitmap().equals(b3.getBitmap())){
				int result = myBet * 50;
				toast = Toast.makeText(MainActivity.this, "You won " + result + " Dollars!!! :D", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
			}
			else if(b1.getBitmap().equals(b2.getBitmap())){
				int result = myBet * 5;
				toast = Toast.makeText(MainActivity.this, "You won " + result + " Dollars!!! :D", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
			}
			else if(b2.getBitmap().equals(b3.getBitmap())){
				int result = myBet * 5;
				toast = Toast.makeText(MainActivity.this, "You won " + result + " Dollars!!! :D", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
			}
			else if(b1.getBitmap().equals(b3.getBitmap())){
				int result = myBet * 5;
				toast = Toast.makeText(MainActivity.this, "You won " + result + " Dollars!!! :D", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
			}
			else {
				toast = Toast.makeText(MainActivity.this, "You won shit!!! :D", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
			}
		}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        getMenuInflater().inflate(R.menu.activity_main_actions, menu);
        
        return true;
    }
	
	/**
     * Listener for Choose button
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Launch the function appropriated when the button is "choose your bet" is clicked	
        switch(item.getItemId())
        {
	        case R.id.bet_choosing: 
	        {
	        	Toast toast = Toast.makeText(MainActivity.this, "Choose your bet", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
				Intent intent = new Intent(MainActivity.this, SetPreferenceActivity.class);
		        startActivityForResult(intent, 0);
	            return true;
	        }
	        default:
	        {
	            return super.onOptionsItemSelected(item);
	        }
        }
    }
    
    
}
