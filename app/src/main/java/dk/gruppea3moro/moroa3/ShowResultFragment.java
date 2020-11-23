package dk.gruppea3moro.moroa3;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dk.gruppea3moro.moroa3.data.DataController;
import dk.gruppea3moro.moroa3.model.AppState;
import dk.gruppea3moro.moroa3.model.EventDTO;
import dk.gruppea3moro.moroa3.model.SearchCriteria;


public class ShowResultFragment extends Fragment {

    String[] eventArray = {"Fælles spisning", "Koncert", "Banko", "Sang", "Rundvisning", "The og kage"};
    // Vi laver en arrayliste så vi kan fjerne/indsætte elementer
    ArrayList<String> events = new ArrayList<>(Arrays.asList(eventArray));

    RecyclerView recyclerView;

    ArrayList<EventDTO> eventDTOs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Gets SearchCriteria from appstate
        SearchCriteria searchCriteria = AppState.get().getSearchCriteria();


        //Create RecyclerView -  empty at first
        RecyclerView rv = new RecyclerView(getContext());


        //Get events with DataController from BackgroundThread
        Executor bgThread = Executors.newSingleThreadExecutor();
        Handler uiThread = new Handler();
        bgThread.execute(() ->{
            //Gets event from searchCriteria via. DataController
            eventDTOs= DataController.get().searchEvents(searchCriteria);

            uiThread.post(()->{
                // Inflate the layout (recyclerview) for this fragment
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                rv.setAdapter(adapter);
            });
        });

        //TODO lav LOADING-animation med MaterialIO eller lign.
        Toast.makeText(getContext(), "Loader...", Toast.LENGTH_SHORT).show();

        //return recyclerview
        return rv;
    }

    RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
        @Override
        public int getItemCount() {
            return eventDTOs.size();
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
            //Get views
            System.out.println("onBindViewHolder " + position);
            TextView titleTV = vh.itemView.findViewById(R.id.title_textView_RV);
            TextView areaTV = vh.itemView.findViewById(R.id.area_textView_RV);
            TextView dateTV = vh.itemView.findViewById(R.id.date_textView_RV);
            TextView timeTV = vh.itemView.findViewById(R.id.time_textView_RV);
            ImageView imageView = vh.itemView.findViewById(R.id.showevent_imageView_RV);

            //Get current event
            EventDTO currentEvent = eventDTOs.get(position);
            System.out.println(currentEvent);


            //Set views from current event data
            titleTV.setText(currentEvent.getTitle());
            areaTV.setText(currentEvent.getAddressDTO().getArea()); //TODO fix evt. indfør koordinater
            dateTV.setText(currentEvent.getStartDay());
            timeTV.setText(currentEvent.getStartTime());




            Executor bgThread = Executors.newSingleThreadExecutor();
            Handler uiThread = new Handler();
            bgThread.execute(() ->{
                //Get image via link in background
                Drawable image = DataController.loadImageFromURL(currentEvent);
                uiThread.post(()->{
                    imageView.setImageDrawable(image);
                });
            });
            imageView.setImageResource(R.drawable.default_event); //TODO her bør være en default MORO-billede
        }
    };


}