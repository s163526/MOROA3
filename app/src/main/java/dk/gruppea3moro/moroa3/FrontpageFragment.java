package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import dk.gruppea3moro.moroa3.data.DataController;
import dk.gruppea3moro.moroa3.model.AppState;
import dk.gruppea3moro.moroa3.model.EventDTO;

public class FrontpageFragment extends Fragment implements View.OnClickListener {

    Button rightNowButton, findEventButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_frontpage, container, false);

        //Call method to get featured event from bg-thread and more
        setupFeaturedEvent();

        //Buttons
        rightNowButton = root.findViewById(R.id.rightNowButtonFP);
        findEventButton = root.findViewById(R.id.findEventButtonFP);
        findEventButton.setOnClickListener(this);
        rightNowButton.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        MainActivity ma = ((MainActivity)getActivity());
        if (v == findEventButton) {
            //Put the selected fragment to top of backstack-deque.
            AppState.get().pushToBackstackDequeTop(R.id.fragment_find_event);
            //Set selection on bottom navigation bar
            ma.setBottonNavSelection(R.id.fragment_find_event);
            //Get fragment object and load
            Fragment f =AppState.getFragmentFromLayoutId(R.id.fragment_find_event);
            ((MainActivity)getActivity()).loadFragment(f);
        }

        else if (v == rightNowButton) {
            //Put the selected fragment to top of backstack-deque.
            AppState.get().pushToBackstackDequeTop(R.id.fragment_right_now);
            //Set selection on bottom navigation bar
            ma.setBottonNavSelection(R.id.fragment_right_now);
            //Get fragment object and load
            Fragment f =AppState.get().getFragmentFromLayoutId(R.id.fragment_right_now);
            ((MainActivity)getActivity()).loadFragment(f);
        }
    }

    public void setupFeaturedEvent(){
        //Create object for bg and fg threads
        Executor bgThread = Executors.newSingleThreadExecutor();
        Handler uiThread = new Handler();

        //Execute bg thread
        bgThread.execute(() ->{
            //Get featured event with DataController from BackgroundThread
            EventDTO featuredEventDTO= DataController.get().getFeaturedEvent();

            //Get ready for fragment transaction for featured event
            Bundle b = new Bundle();
            b.putSerializable("event",featuredEventDTO);
            Fragment featuredEventFragment = new ShowEventFragment(); //TODO burde nok være en anden type .feks. smallShowEventFragment
            featuredEventFragment.setArguments(b);

            //Post the fragment transaction on UI-thread
            uiThread.post(()->{
                if (getActivity()!= null){
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.featuredEventFrontpageFL, featuredEventFragment)
                            .commit();
                }

            });
        });






    }
}