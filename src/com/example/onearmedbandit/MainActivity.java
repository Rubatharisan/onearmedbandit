package com.example.onearmedbandit;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //declaring and setting the 3 imageViews
        
        final ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView iv3 = (ImageView) findViewById(R.id.imageView3);
        
        iv1.setBackgroundResource(R.animator.animlist1);
        iv2.setBackgroundResource(R.animator.animlist2);
        iv3.setBackgroundResource(R.animator.animlist3);
        
        final AnimationDrawable anim1 = (AnimationDrawable) iv1.getBackground();
        final AnimationDrawable anim2 = (AnimationDrawable) iv2.getBackground();
        final AnimationDrawable anim3 = (AnimationDrawable) iv3.getBackground();
        
        
        
        //Button Start listener
        
        final Button bStart = (Button) findViewById(R.id.button4);
        
        bStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {	
				
				anim1.start();
				anim2.start();
				anim3.start();
				
				Toast toast = Toast.makeText(MainActivity.this, "The game has been started, use the stop buttons", 100000);
				toast.setGravity(Gravity.TOP, 0, 0);
				toast.show();
				
			}
		});
        
        // Button Stop1 listener
        
        Button bStop1 = (Button) findViewById(R.id.button1);
        
        bStop1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim1.stop();
				
				
			}
		});
        
     // Button Stop2 listener
        
        Button bStop2 = (Button) findViewById(R.id.button2);
        
        bStop2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim3.stop();
			}
		});
        
        //Button Stop3 listener
        
        Button bStop3 = (Button) findViewById(R.id.button3);
        
        bStop3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				anim2.stop();
				
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
