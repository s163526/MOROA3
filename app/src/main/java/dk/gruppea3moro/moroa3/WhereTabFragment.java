package dk.gruppea3moro.moroa3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class WhereTabFragment extends Fragment {

    private final String places[] ={"Nørrebro", "Islandsbrygge", "Indre By", "Østerbro", "Nordvest", "Valby", "Brønshøj & Husum", "Amager", "Vesterbro", "Vanløse", "Christianshavn", "Refshaleøen"} ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rv = inflater.inflate(R.layout.fragment_where_tab, container, false);
        GridView gridView = rv.findViewById(R.id.gridview);
        WhereAdapter whereAdapter = new WhereAdapter(getContext(), places);
        gridView.setAdapter(whereAdapter);



        return rv;
    }

}