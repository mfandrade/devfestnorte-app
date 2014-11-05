package info.mfandrade.mobile.devfestnorte;

import info.mfandrade.mobile.devfestnorte.rawdata.Event;
import info.mfandrade.mobile.devfestnorte.rawdata.Talk;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TalksFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View rootView = inflater.inflate(R.layout.fragment_talks, container, false);
		ListView listTalks = (ListView) rootView.findViewById(R.id.list_talks);

		Bundle args = getArguments();
		int section = args.getInt(TalksActivity.ARG_SELECTED_TAB);
		Talk[] talks = Event.getInstance().getTalks(section);
		System.out.println(talks);

		ArrayAdapter<Talk> adapter = new ArrayAdapter<Talk>(getActivity(), R.layout.layout_listvew, talks);
		listTalks.setAdapter(adapter);

		return rootView;
	}

}
