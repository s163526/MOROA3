package dk.gruppea3moro.moroa3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class WhereTabFragment extends Fragment implements AdapterView.OnItemClickListener {

    private final String places[] ={"Nørrebro", "Islands brygge", "Indre By", "Østerbro", "Nordvest", "Valby", "Brønshøj & Husum", "Amager", "Vesterbro", "Vanløse", "Christians- havn", "Refshale- øen"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO Man skal vente efter at have skiftet mellem Hvad og Hvor før man kan klikke

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.wheretab_gridview, R.id.listeelem_overskrift, places){

        };

        GridView gridView = new GridView(getContext());
        gridView.setOnItemClickListener(this);
        gridView.setNumColumns(3);
        gridView.setBackgroundColor(getResources().getColor(R.color.moroPinkBackground));


        gridView.setMinimumHeight(MainActivity.height*100);
        gridView.setAdapter(adapter);

        return gridView;
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Toast.makeText(getContext(), "Klik på " + position, Toast.LENGTH_SHORT).show();
    }

}