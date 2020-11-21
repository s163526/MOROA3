package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dk.gruppea3moro.moroa3.model.EventDTO;

public class ShowEventFragment extends Fragment {
    TextView title, subtext, price, startDate, endDate, address;
    //TODO add link, image and more?


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_show_result, container, false);
        title = root.findViewById(R.id.titleTVShowEvent);
        subtext = root.findViewById(R.id.descriptionTVShowEvent);
        price = root.findViewById(R.id.priceTVShowEvent);
        startDate = root.findViewById(R.id.dateTVShowEvent);
        address = root.findViewById(R.id.addressTVShowEvent);

        setupEventView();
        return root;
    }

    public void setupEventView(){
        Bundle arguments = getArguments();
        EventDTO eventDTO = (EventDTO) arguments.getSerializable("event");

        //Set text views
        title.setText(eventDTO.getTitle());
        subtext.setText(eventDTO.getSubtext());
        price.setText(""+eventDTO.getPrice());
        startDate.setText(eventDTO.getStartDate().toString());//TODO make this view better maybe?
        address.setText(eventDTO.getAddressDTO().toString()); //TODO make better view of address
    }
}