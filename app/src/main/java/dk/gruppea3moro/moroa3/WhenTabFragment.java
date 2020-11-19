package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;

public class WhenTabFragment extends Fragment implements View.OnClickListener {

    DatePicker picker;
    Button pickDate_button;
    TextView chosenDate_TextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_when_tab, container, false);
        picker = (DatePicker) root.findViewById(R.id.when_datePicker);
        pickDate_button = root.findViewById(R.id.pickDate_button);
        chosenDate_TextView = root.findViewById(R.id.chosenDate_TextView);

        pickDate_button.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if (v == pickDate_button) {
            int month = picker.getMonth() + 1;

            chosenDate_TextView.setText(picker.getDayOfMonth() + "/" + month + "/" + picker.getYear());

            // CategoryTabFragment categoryTabFragment = new CategoryTabFragment();
            // replaceFragment(categoryTabFragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFL, fragment); // give your fragment container id in first parameter
        transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
        transaction.commit();
    }
}