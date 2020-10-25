package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MenuFragment extends Fragment implements View.OnClickListener {
    TextView kontakt_TextView, om_TextView, tip_Textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_frontpage, container, false);
        kontakt_TextView = root.findViewById(R.id.kontakt_textView);
        om_TextView = root.findViewById(R.id.om_textView);
        tip_Textview = root.findViewById(R.id.tip_textView);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == kontakt_TextView) {
            
        }
    }

}