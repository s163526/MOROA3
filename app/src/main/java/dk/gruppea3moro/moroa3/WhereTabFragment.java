package dk.gruppea3moro.moroa3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class WhereTabFragment extends Fragment implements AdapterView.OnItemClickListener {

    private final String places[] ={"Nørrebro", "Islandsbrygge", "Indre By", "Østerbro", "Nordvest", "Valby", "Brønshøj & Husum", "Amager", "Vesterbro", "Vanløse", "Christianshavn", "Refshaleøen"} ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rv = inflater.inflate(R.layout.fragment_where_tab, container, false);

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.fragment_where_tab, R.id.listeelem_overskrift, places);

        GridView gridView = new GridView(getContext());
        gridView.setOnItemClickListener(this);
        gridView.setNumColumns(GridView.AUTO_FIT);

        //wow
        //gridView.setAdapter(adapter);

        //setContentView(gridView);



        return rv;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}