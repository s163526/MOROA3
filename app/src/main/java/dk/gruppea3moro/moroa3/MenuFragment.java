package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dk.gruppea3moro.moroa3.model.AppState;


public class MenuFragment extends Fragment implements View.OnClickListener {
    TextView contact_TextView, about_TextView, tip_Textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        contact_TextView = root.findViewById(R.id.kontakt_textView);
        about_TextView = root.findViewById(R.id.om_textView);
        tip_Textview = root.findViewById(R.id.tip_textView);

        contact_TextView.setOnClickListener(this);
        about_TextView.setOnClickListener(this);
        tip_Textview.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        MainActivity ma = ((MainActivity) getActivity());
        if (v == contact_TextView) {
            AppState.get().pushToBackstackDequeTop(R.id.fragment_contact_us);
            ContactUsFragment contactUsFragment = new ContactUsFragment();
            replaceFragment(contactUsFragment);
        } else if (v == about_TextView) {
            AppState.get().pushToBackstackDequeTop(R.id.fragment_about_us);
            AboutUsFragment aboutUsFragment = new AboutUsFragment();
            replaceFragment(aboutUsFragment);
        } else if (v == tip_Textview) {
            AppState.get().pushToBackstackDequeTop(R.id.fragment_tip_us);
            TipUsFragment tipUsFragment = new TipUsFragment();
            replaceFragment(tipUsFragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFL, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}