package info.mfandrade.mobile.devfestnorte;

import info.mfandrade.mobile.devfestnorte.rawdata.Event;
import info.mfandrade.mobile.devfestnorte.rawdata.Talk;

import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

	// Identificadores das abas da tela principal
	public static final int TALKS_MOBILE = 0;
	public static final int TALKS_WEBCLOUD = 1;

	/**
	 * O {@link android.support.v4.view.PagerAdapter} é quem vai prover
	 * os fragments para cada uma das abas.  Foi usada uma subclasse de
	 * {@link FragmentPagerAdapter} que vai manter cada fragment na memória.
	 * Assim, só deve ser usado se você tiver umas poucas abas.  Caso
	 * contrário, é recomendável substituí-lo em favor de 
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);					// De novo, obrigatório
		setContentView(R.layout.activity_main);				// Apontando o layout desta activity

		final ActionBar actionBar = getSupportActionBar();				// Nosso app vai ficar compatível desde o Froyo
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);	// Assim se diz que a activity usa abas

		// Cria o adapter que vai retornar o fragment com o conteúdo para cada aba da activity
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Seta o adapter no ViewPager
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// Ao trocar entre abas, deixa com aparência de selecionada a aba correspondente.
		// Também podíams fazer isso com ActionBar.Tab#select() se tivéssemos uma
		// referência para a aba.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// Adiciona cada uma das abas prevista na action bar
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {	// getCount foi sobrescrito com a qtd de abas
			// Cria uma aba cujo título vai ser o texto do resource string correspondente.
			// Também aponta onde está implementado o tratador de troca de abas (listener).
			actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Infla o menu, adicionando-o à action bar.  Vide res/menu/main.xml
		// Lembrando que, em dispositivos com botão Opções físico, os itens
		// não-colapsados do menu aparecem abaixo na tela.
		// Nos demais dispositivos, é o comportamento padrão da action bar.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Trata os cliques nos itens de menu da actionbar.
		// Para lidar com o botão Voltar automaticamente, basta
		// especificar parent activities no AndroidManifest.xml
		
		int id = item.getItemId();
		switch (id) {	// TODO: Falta tratar estes eventos, trocando o fragment com as informações em questão
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
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// Troca para a aba quando ela estiver selecionada no ViewPager
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	/**
	 * Um {@link FragmentPagerAdapter} que retorna um fragment correspondente a
	 * uma das seções/abas/páginas.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// Este getItem é chamado para instanciar o fragment para uma dada página.
			// Retorna um PlaceholderFragment.  Aqui, para simplificar, uma classe
			// interna estática que está mais abaixo neste código, mas você pode (deve)
			// colocar suas classes de fragment em pacotes separados numa boa.
			return PlaceholderFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			// A quantidade de abas.
			// Como dito, para o FragmentPagerAdapter é bom serem só umas poucas.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// Define o título das abas, centralizados nas strings de recursos.
			Locale l = Locale.getDefault();
			switch (position) {
			case TALKS_MOBILE:
				return getString(R.string.title_tab_mobile).toUpperCase(l);
			case TALKS_WEBCLOUD:
				return getString(R.string.title_tab_webcloud).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * Um placeholder que só contém uma view.  No caso, uma ListView.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * O nome da variável que vai conter qual seção/aba/página foi selecionada.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Retorna uma nova instância deste fragment com a seção dada.
		 * O PageAdapter pega o fragment daqui.
		 * Veja que o número da seção selecionada vai como argumento no Bundle. 
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		/**
		 * Enquanto que numa activity o ciclo inicia em onCreate, num fragment têm-se o método onCreateView.
		 * Simplesmente seta os dados da listagem no listview presenta no fragment dependendo da seção selecionada.  
		 * Aliás, a seção selecionada é obtida justamente do Bundle que tem os argumentos passados.
		 */
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			ListView listTalks = (ListView) rootView.findViewById(R.id.list_talks);

			Bundle args = getArguments();
			int section = args.getInt(ARG_SECTION_NUMBER);
			Talk[] schedule = Event.getInstance().getTalks(section);
			ArrayAdapter<Talk> adapter = new ArrayAdapter<Talk>(listTalks.getContext(), R.layout.layout_listvew, schedule);
			listTalks.setAdapter(adapter);

			return rootView;
		}
	}

}
