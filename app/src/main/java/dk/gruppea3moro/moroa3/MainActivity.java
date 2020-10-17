package dk.gruppea3moro.moroa3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment bottomBarFragment, mainFragment;

    Button rightNowButton, findEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Top bar

        //Main FL
        mainFragment = new FrontpageFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainFL, mainFragment)  // tom container i layout
                .commit();

        //Buttons
        rightNowButton = findViewById(R.id.rightNowButton);
        findEventButton = findViewById(R.id.findEventButton);
        findEventButton.setOnClickListener(this);
        rightNowButton.setOnClickListener(this);

        //Bottombar
        bottomBarFragment = new BottomBarFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.bottomBarFL, bottomBarFragment)  // tom container i layout
                .commit();
    }

    @Override
    public void onClick(View v) {
        if (v == findEventButton) {
            mainFragment = new ShowResultFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.findEventFragment, mainFragment)  // tom container i layout
                    .commit();

        }
        if (v == rightNowButton) {
            mainFragment = new ShowResultFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.mainFL, mainFragment)  // tom container i layout
                    .commit();
        }
    }
}