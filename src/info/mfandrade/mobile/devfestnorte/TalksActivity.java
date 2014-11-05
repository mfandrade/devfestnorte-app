package info.mfandrade.mobile.devfestnorte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.RelativeLayout;

public class TalksActivity extends ActionBarActivity implements ActionBar.TabListener {

	public static final int ID_TAB_MOBILE = 0;
	public static final int ID_TAB_WEBCLOUD = 1;
	public static final String ARG_SELECTED_TAB = "info.mfandrade.mobile.devfestnorte.ARG_SELECTED_TAB";
	private ActionBar bar;
	private FragmentTransaction ft;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bar = getSupportActionBar();
		bar.addTab(bar.newTab().setText(R.string.title_tab_mobile).setTabListener(this));
		bar.addTab(bar.newTab().setText(R.string.title_tab_webcloud).setTabListener(this));
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragtran) {
		
		final String tabMobile   = getResources().getString(R.string.title_tab_mobile);
		final String tabWebCloud = getResources().getString(R.string.title_tab_webcloud);
		
		Fragment frag = new TalksFragment();
		Bundle args = new Bundle();
		
		RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
		mainLayout.removeAllViews();
		
		if(tab.getText().equals(tabMobile)) {
			args.putInt(ARG_SELECTED_TAB, ID_TAB_MOBILE);
			
		} else if (tab.getText().equals(tabWebCloud)) {
			args.putInt(ARG_SELECTED_TAB, ID_TAB_WEBCLOUD);
		}
		frag.setArguments(args);
		
		ft = getSupportFragmentManager().beginTransaction();
		ft.add(mainLayout.getId(), frag);
		ft.commit();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragtran) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragtran) {
	}
}
