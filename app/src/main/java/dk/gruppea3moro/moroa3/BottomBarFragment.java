package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BottomBarFragment extends Fragment implements View.OnClickListener {

    Button findEventButton, rightNowButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_bottom_bar, container, false);

        //Buttons
        rightNowButton = root.findViewById(R.id.rightNowButtonBB);
        findEventButton = root.findViewById(R.id.findEventButtonBB);
        findEventButton.setOnClickListener(this);
        rightNowButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return root;
    }


    public void onClick(View v) {
        if (v == findEventButton) {

            Fragment findEventFragment = new FindEventFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFL, findEventFragment)  // tom container i layout
                    .addToBackStack(null).commit();
        } else if (v == rightNowButton) {
            Fragment findEventFragment = new ShowResultFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.mainFL, findEventFragment)  // tom container i layout
                    .addToBackStack(null).commit();
        }
    }
}