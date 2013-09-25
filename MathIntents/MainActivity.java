package org.vkedco.mobappdev.sumfactorialintents;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{	 
	 static final int FACT_REQUEST_CODE=100;
	 static final int SUM_REQUEST_CODE=101;
	 static EditText mEdTxtInput;
	 static Button mBtnFact;
	 static Button mBtnSum;
	 static TextView mEdTxtOutput;
	 static Activity mThisAct = null;

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
				
		mEdTxtInput = (EditText) findViewById(R.id.txtInput);		
		mBtnFact=(Button)findViewById(R.id.factButton);
		mBtnSum = (Button)findViewById(R.id.sumButton);
		mEdTxtOutput=(TextView)findViewById(R.id.txtOutput);
		mThisAct = this;
				
		mBtnFact.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 1. Create an intent
				Intent calcFactIntent = new Intent(mThisAct, FactCalcAct.class);
				int n = 0;
				// 2. Put data into the intent: "N" 10
				try {
					n = Integer.parseInt(mEdTxtInput.getText().toString());
				}
				catch ( NumberFormatException ex ) {
					// If the user's input cannot be parsed into an integer,
					// toast an exception
					Toast
						.makeText(mThisAct, ex.toString(), Toast.LENGTH_LONG)
						.show();
					return;
					
				}
				
				calcFactIntent.putExtra("N", n);
				// startActivityForResult to request Android to launch the factorial activity
		        startActivityForResult(calcFactIntent, FACT_REQUEST_CODE);//
			}
			
		});
		
		mBtnSum.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent calcSumIntent = new Intent(mThisAct, SumCalcAct.class);
				int n = 0;
				// 2. Put data into the intent: "N" 10
				try {
					n = Integer.parseInt(mEdTxtInput.getText().toString());
				}
				catch ( NumberFormatException ex ) {
					// If the user's input cannot be parsed into an integer,
					// toast an exception
					Toast
						.makeText(mThisAct, ex.toString(), Toast.LENGTH_LONG)
						.show();
					return;
					
				}
				calcSumIntent.putExtra("N", n);
		        startActivityForResult(calcSumIntent, SUM_REQUEST_CODE);
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		 // check if the request code is same as what is passed  here it is 2
        if(requestCode == FACT_REQUEST_CODE) {
		       	 if(null != data) {	 	
		       		 // fetch the message String
		       		 final int n = data.getIntExtra("N", 0);
		       		 final long nfact = data.getLongExtra("N!", 0);
		       		 // Set the message string in textView
		       		 mEdTxtOutput.setText(n + "!" + " = " + nfact);
		       	 }
	         }
        
        if(requestCode == SUM_REQUEST_CODE) {
	       	 if(null != data) {	 	
	       		 // fetch the message String
	       		 final int n = data.getIntExtra("N", 0);
	       		 final long nfact = data.getLongExtra("N+", 0);
	       		 // Set the message string in textView
	       		 mEdTxtOutput.setText("[0, " + n + "]" + "+" + " = " + nfact);
	       	 }
        }
	}



}
