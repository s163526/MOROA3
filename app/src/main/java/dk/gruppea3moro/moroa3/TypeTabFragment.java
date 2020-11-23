package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

public class TypeTabFragment extends Fragment implements AdapterView.OnItemClickListener {

    private final String events[] = {"Koncert", "Udstilling & kunst", "Litteratur", "Film", "Comedy", "Talk", "Teater & forestill- inger", "Fest", "Gratis", "Sport & spil", "Mad & drikke", "Mode"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO Man skal vente efter at have skiftet mellem Hvad og Hvor før man kan klikke
    View root = inflater.inflate(R.layout.whattab_vertview, container, false);




        return root;

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "Klik på " + position, Toast.LENGTH_SHORT).show();
    }

}