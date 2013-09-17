package org.vkedco.mobappdev.pix_browser_exp_intents_01;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageDisplayerAct_01 extends Activity {

	protected ImageView mImgView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.img_displayer_act01_layout);
		mImgView = (ImageView) this.findViewById(R.id.img_view_01);
		mImgView.setImageDrawable(null);
		int img_num = new Random().nextInt(8) + 1;
		switch ( img_num ) {
		case 1: 
			mImgView.setBackgroundResource(R.drawable.img_01);
			break;
		case 2: 
			mImgView.setBackgroundResource(R.drawable.img_02);
			break;
		case 3: 
			mImgView.setBackgroundResource(R.drawable.img_03);
			break;
		case 4: 
			mImgView.setBackgroundResource(R.drawable.img_04);
			break;
		case 5:
			mImgView.setBackgroundResource(R.drawable.img_05);
			break;
		case 6:
			mImgView.setBackgroundResource(R.drawable.img_06);
			break;
		case 7:
			mImgView.setBackgroundResource(R.drawable.img_07);
			break;
		case 8:
			mImgView.setBackgroundResource(R.drawable.img_08);
			break;
		}
		Toast.makeText(this, getResources().getString(R.string.random_img_msg) + " " + img_num,
				Toast.LENGTH_SHORT).show();
	}
}
