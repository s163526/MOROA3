package dk.gruppea3moro.moroa3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;


public class ShowResultFragment extends Fragment {

    String[] eventArray = {"Fælles spisning", "Koncert", "Banko", "Sang", "Rundvisning", "The og kage"};
    // Vi laver en arrayliste så vi kan fjerne/indsætte elementer
    ArrayList<String> events = new ArrayList<>(Arrays.asList(eventArray));

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        return rv;
    }

    RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        @Override
        public int getItemCount() {
            return events.size();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            System.out.println("onCreateViewHolder ");
            View itemView = getLayoutInflater().inflate(R.layout.showevent_recyclerview, parent, false);
            return new RecyclerView.ViewHolder(itemView) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder vh, int position) {
            System.out.println("onBindViewHolder " + position);
            TextView titel = vh.itemView.findViewById(R.id.titel_textView);
            TextView afstand = vh.itemView.findViewById(R.id.afstand_textView);
            TextView dato = vh.itemView.findViewById(R.id.dato_textView);
            TextView tidspunkt = vh.itemView.findViewById(R.id.tidspunkt_textView);
            ImageView billede = vh.itemView.findViewById(R.id.showevent_imageView);

            titel.setText(events.get(position));
            afstand.setText("5 km"); //TODO skal ikke hardcodes
            dato.setText("12/12 - 2021"); //TODO skal ikke hardcodes
            tidspunkt.setText("15:00 - 20:00"); //TODO skal ikke hardcodes
            billede.setImageResource(R.drawable.event);
        }
    };
}