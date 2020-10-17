package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


//TODO viewpager
public class FindEventFragment extends Fragment implements View.OnClickListener {
    Button rightNowButton, findEventButton;
    Fragment findEventFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_find_event, container, false);

        //Buttons
        rightNowButton = v.findViewById(R.id.rightNowButton);
        findEventButton = v.findViewById(R.id.findEventButton);
        findEventButton.setOnClickListener(this);
        rightNowButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == findEventButton) {
            findEventFragment = new ShowResultFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.findEventFragment, findEventFragment)  // tom container i layout
                    .commit();
        }

        if (v == rightNowButton) {
            findEventFragment = new ShowResultFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.mainFL, findEventFragment)  // tom container i layout
                    .commit();
        }
    }
}