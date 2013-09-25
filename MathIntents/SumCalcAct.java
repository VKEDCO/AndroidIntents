package org.vkedco.mobappdev.sumfactorialintents;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SumCalcAct extends Activity implements OnClickListener {

	TextView mTvDisplayText;
	Button mBtnSum;
	static int mN;
	static final int SUM_RESULT_CODE = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sum_layout);

		Intent inputIntent = getIntent();
		mN = inputIntent.getIntExtra("N", 1);

		mBtnSum = (Button) findViewById(R.id.getSumButton);

		mBtnSum.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		final long result = calcSum(mN);
		// get the Entered message
		Intent intentMessage = new Intent();
		// put the message in Intent
		intentMessage.putExtra("N", mN);
		intentMessage.putExtra("N+", result);
		// Set The Result in Intent
		setResult(SUM_RESULT_CODE, intentMessage);
		// finish The activity
		finish();

	}

	static final long calcSum(int i) {
		long rslt = 0;

		for (long j = 1; j <= i; j++)
			rslt += j;

		return rslt;
	}

}
