package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        kontakt_TextView = root.findViewById(R.id.kontakt_textView);
        om_TextView = root.findViewById(R.id.om_textView);
        tip_Textview = root.findViewById(R.id.tip_textView);

        kontakt_TextView.setOnClickListener(this);
        om_TextView.setOnClickListener(this);
        tip_Textview.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == kontakt_TextView) {
            ContactUsFragment contactUsFragment = new ContactUsFragment();
            replaceFragment(contactUsFragment);
        } else if (v == om_TextView) {
            AboutUsFragment aboutUsFragment = new AboutUsFragment();
            replaceFragment(aboutUsFragment);
        } else if (v == tip_Textview) {
            TipUsFragment tipUsFragment = new TipUsFragment();
            replaceFragment(tipUsFragment);
        }
    }
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFL, fragment ); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }

}