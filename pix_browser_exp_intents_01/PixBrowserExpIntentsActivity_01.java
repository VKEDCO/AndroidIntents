package org.vkedco.mobappdev.pix_browser_exp_intents_01;

// images for this app are in https://github.com/VKEDCO/AndroidIntents/blob/master/ExplicitIntentsApp01.zip

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PixBrowserExpIntentsActivity_01 extends Activity {
	
	static Button mBtnDisplay = null;
	static Activity mThisAct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix_browser_exp_intents_activity_01);
        mBtnDisplay = (Button) this.findViewById(R.id.btn_display);
        mThisAct = this;
        mBtnDisplay.setOnClickListener(
        		new OnClickListener() {
					@Override
					public void onClick(View v) {
						// 1. Create an explicit intent
						Intent i = new Intent(mThisAct, ImageDisplayerAct_01.class);
						// 2. Request Android to consider it.
						startActivity(i);
					}	
        		}
        );
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pix_browser_exp_intents_activity_01, menu);
        return true;
    }
    
}
