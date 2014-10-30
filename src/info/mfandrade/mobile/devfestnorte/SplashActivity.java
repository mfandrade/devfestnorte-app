package info.mfandrade.mobile.devfestnorte;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);			// Obrigatório para funcionamento adequado
		setContentView(R.layout.activity_splash);	// Aponta o layout da view

		ImageView splash = (ImageView) findViewById(R.id.splash);	// Pega o espaço para a imagem no layout
		splash.setOnClickListener(new OnClickListener() {			// O que acontece quando clicar na imagem...

			@Override
			public void onClick(View view) {
				// Simplesmente vai para a main activity
				Intent main = new Intent(SplashActivity.this, MainActivity.class);
				startActivity(main);
			}
		});

		// DEBUG.  Exibe a densidade da tela do dispositivo para ajudar a identificar os resources adequados.
		// DisplayMetrics metrics = new DisplayMetrics();
		// getWindowManager().getDefaultDisplay().getMetrics(metrics);
		// Toast.makeText(this, "Density: " + metrics.densityDpi, Toast.LENGTH_SHORT).show();
	}
}
