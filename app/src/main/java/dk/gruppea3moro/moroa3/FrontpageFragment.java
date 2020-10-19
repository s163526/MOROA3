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
        if (v == findEventButton) {
            Fragment findEventFragment = new FindEventFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFL, findEventFragment)  // tom container i layout
                    .addToBackStack(null).commit();
        }

        else if (v == rightNowButton) {
            Fragment findEventFragment = new ShowResultFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFL, findEventFragment)  // tom container i layout
                    .addToBackStack(null).commit();
        }
    }
}