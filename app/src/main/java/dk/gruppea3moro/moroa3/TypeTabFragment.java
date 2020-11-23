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
    int heights = MainActivity.height;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //TODO Man skal vente efter at have skiftet mellem Hvad og Hvor før man kan klikke

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.whattab_gridview, R.id.listeelem_overskrift, events){

        };

        GridView gridView = new GridView(getContext());
        gridView.setOnItemClickListener(this);
        gridView.setNumColumns(3);
        gridView.setBackgroundColor(getResources().getColor(R.color.moroYellowBackground));


        /*GridLayout.LayoutParams params =
                new GridLayout.LayoutParams(gridView.getLayoutParams());

        params.rowSpec = GridLayout.spec(0, 1);    // First cell in first row uses rowSpan 1.
        params.columnSpec = GridLayout.spec(0, 2); // First cell in first column uses columnSpan 2.
        gridView.setLayoutParams(params);*/

        gridView.setAdapter(adapter);
    gridView.post()
        return gridView;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), "Klik på " + position, Toast.LENGTH_SHORT).show();
    }




   /* private void changeColorGreen(TextView textView) {
        textView.setTextColor(Color.GREEN);
        textView.setBackgroundResource(R.drawable.greenborder);

    }

    private void changeColorBlack(TextView textView) {
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.blackborder);

    }*/
}