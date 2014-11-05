package info.mfandrade.mobile.devfestnorte;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class TalksActivity extends ActionBarActivity implements ActionBar.TabListener {

	public static final int ID_TAB_MOBILE = 0;
	public static final int ID_TAB_WEBCLOUD = 1;
	public static final String ARG_SELECTED_TAB = "info.mfandrade.mobile.devfestnorte.ARG_SELECTED_TAB";
	private ActionBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talks);

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
	public boolean onOptionsItemSelected(MenuItem menuItem) {

		int item = menuItem.getItemId();
		switch (item) {
		case R.id.action_talks:
			return true;
		case R.id.action_speakers:
			return true;
		case R.id.action_place:
			return true;
		case R.id.action_city:
			return true;
		case R.id.action_about:
			return true;
		default:
			return super.onOptionsItemSelected(menuItem);
		}
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragtran) {

		final String tabMobile = getResources().getString(R.string.title_tab_mobile);
		final String tabWebCloud = getResources().getString(R.string.title_tab_webcloud);

		Bundle args = new Bundle();

		if (tab.getText().equals(tabMobile)) {
			args.putInt(ARG_SELECTED_TAB, ID_TAB_MOBILE);

		} else if (tab.getText().equals(tabWebCloud)) {
			args.putInt(ARG_SELECTED_TAB, ID_TAB_WEBCLOUD);
		}
		Fragment frag = new TalksFragment();
		frag.setArguments(args);

		_showFragment(frag);
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragtran) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragtran) {
	}

	private void _showFragment(Fragment fragment) {

		RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
		mainLayout.removeAllViews();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(mainLayout.getId(), fragment);
		ft.commit();
	}
}
