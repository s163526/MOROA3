package dk.gruppea3moro.moroa3;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CategoryTabFragment extends Fragment implements View.OnClickListener {

    TextView category1_textView, category2_textView, category3_textView, category4_textView,
            category5_textView, category6_textView, category7_textView, category8_textView,
            category9_textView, category10_textView, category11_textView, category12_textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_category_tab, container, false);

        //TODO erstat med GridView

        category1_textView = root.findViewById(R.id.category1_textView);
        category2_textView = root.findViewById(R.id.category2_textView);
        category3_textView = root.findViewById(R.id.category3_textView);
        category4_textView = root.findViewById(R.id.category4_textView);
        category5_textView = root.findViewById(R.id.category5_textView);
        category6_textView = root.findViewById(R.id.category6_textView);
        category7_textView = root.findViewById(R.id.category7_textView);
        category8_textView = root.findViewById(R.id.category8_textView);
        category9_textView = root.findViewById(R.id.category9_textView);
        category10_textView = root.findViewById(R.id.category10_textView);
        category11_textView = root.findViewById(R.id.category11_textView);
        category12_textView = root.findViewById(R.id.category12_textView);

        category1_textView.setOnClickListener(this);
        category2_textView.setOnClickListener(this);
        category3_textView.setOnClickListener(this);
        category4_textView.setOnClickListener(this);
        category5_textView.setOnClickListener(this);
        category6_textView.setOnClickListener(this);
        category7_textView.setOnClickListener(this);
        category8_textView.setOnClickListener(this);
        category9_textView.setOnClickListener(this);
        category10_textView.setOnClickListener(this);
        category11_textView.setOnClickListener(this);
        category12_textView.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View view) {

        if (view == category1_textView) {
            if (category1_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category1_textView);
            } else changeColorBlack(category1_textView);

        } else if (view == category2_textView) {
            if (category2_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category2_textView);
            } else changeColorBlack(category2_textView);

        } else if (view == category3_textView) {
            if (category3_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category3_textView);
            } else changeColorBlack(category3_textView);

        } else if (view == category4_textView) {
            if (category4_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category4_textView);
            } else changeColorBlack(category4_textView);

        }else if (view == category5_textView) {
            if (category5_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category5_textView);
            } else changeColorBlack(category5_textView);

        }else if (view == category6_textView) {
            if (category6_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category6_textView);
            } else changeColorBlack(category6_textView);

        } else if (view == category7_textView) {
            if (category7_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category7_textView);
            } else changeColorBlack(category7_textView);

        } else if (view == category8_textView) {
            if (category8_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category8_textView);
            } else changeColorBlack(category8_textView);

        } else if (view == category9_textView) {
            if (category9_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category9_textView);
            } else changeColorBlack(category9_textView);

        } else if (view == category10_textView) {
            if (category10_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category10_textView);
            } else changeColorBlack(category10_textView);

        } else if (view == category11_textView) {
            if (category11_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category11_textView);
            } else changeColorBlack(category11_textView);

        } else if (view == category12_textView) {
            if (category12_textView.getCurrentTextColor() != Color.GREEN) {
                changeColorGreen(category12_textView);
            } else changeColorBlack(category12_textView);
        }

    }

    private void changeColorGreen(TextView textView) {
        textView.setTextColor(Color.GREEN);
        textView.setBackgroundResource(R.drawable.greenborder);

    }

    private void changeColorBlack(TextView textView) {
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundResource(R.drawable.blackborder);

    }
}