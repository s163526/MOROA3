package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FrontpageFragment extends Fragment implements View.OnClickListener {

    Button rightNowButton, findEventButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_frontpage, container, false);

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
            ma.pushToBackstackDequeTop(R.id.fragment_find_event);
            //Set selection on bottom navigation bar
            ma.setBottonNavSelection(R.id.fragment_find_event);
            //Get fragment object and load
            Fragment f =((MainActivity)getActivity()).getFragmentFromLayoutId(R.id.fragment_find_event);
            ((MainActivity)getActivity()).loadFragment(f);
        }

        else if (v == rightNowButton) {
            //Put the selected fragment to top of backstack-deque.
            ma.pushToBackstackDequeTop(R.id.fragment_right_now);
            //Set selection on bottom navigation bar
            ma.setBottonNavSelection(R.id.fragment_right_now);
            //Get fragment object and load
            Fragment f =((MainActivity)getActivity()).getFragmentFromLayoutId(R.id.fragment_right_now);
            ((MainActivity)getActivity()).loadFragment(f);
        }
    }
}