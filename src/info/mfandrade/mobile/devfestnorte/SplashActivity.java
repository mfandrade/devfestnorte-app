package info.mfandrade.mobile.devfestnorte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		ImageView splash = (ImageView) findViewById(R.id.splash);
		splash.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent main = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(main);
			}
		});

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);

		Toast.makeText(this, "Density: " + metrics.densityDpi, Toast.LENGTH_SHORT).show();
	}
}
