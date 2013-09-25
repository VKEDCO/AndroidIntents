package org.vkedco.mobappdev.sumfactorialintents;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FactCalcAct extends Activity implements OnClickListener {

	TextView displayText;
	Button factBtn;
	static int mN;
	static final int FACT_RESULT_CODE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fact_layout);

		Intent inputIntent = getIntent();
		mN = inputIntent.getIntExtra("N", 1);

		factBtn = (Button) findViewById(R.id.getFactButton);

		factBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		final long result = calcFactorial(mN);
		// get the Entered message
		Intent intentMessage = new Intent();
		// put the message in Intent
		intentMessage.putExtra("N", mN);
		intentMessage.putExtra("N!", result);
		// Set The Result in Intent
		setResult(FACT_RESULT_CODE, intentMessage);
		// finish The activity
		finish();

	}

	static final long calcFactorial(int i) {
		long rslt = 1;

		for (long j = 1; j <= i; j++)
			rslt *= j;

		return rslt;
	}

}
