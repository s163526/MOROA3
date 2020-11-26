package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MoodFragment extends Fragment {
    private final String events[] = {"Du vil ikke hjem, men videre", "Du vil ud i det blå", "Du har tømmermænd", "Du vil udvide din horisont", "Du har tomme lommer", "Mad gør dig glad", "Du vil forkæle dig selv", "Du vil imponere din date", "De gamle kommer på besøg", "Du vil have gang i kroppen", "Temp", "Temp"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO Man skal vente efter at have skiftet mellem Hvad og Hvor før man kan klikke

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.whattab_gridview, R.id.listeelem_overskrift, events);

        GridView gridView = new GridView(getContext());
        gridView.setNumColumns(3);
        gridView.setBackgroundColor(getResources().getColor(R.color.moroYellowBackground));

        gridView.setAdapter(adapter);

        return gridView;

    }



}