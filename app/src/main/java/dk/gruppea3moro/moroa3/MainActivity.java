package dk.gruppea3moro.moroa3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//TODO burgermenu(kontakt os osv), søge menu med filtre, evt?
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Fragment bottomBarFragment, mainFragment, topBarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Top bar
        topBarFragment = new TopBarFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.topBarFL, topBarFragment)  // tom container i layout
                .commit();


        //Main FL
        mainFragment = new FrontpageFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainFL, mainFragment)  // tom container i layout
                .commit();

        //Bottombar
        bottomBarFragment = new BottomBarFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.bottomBarFL, bottomBarFragment)  // tom container i layout
                .commit();
    }

    @Override
    public void onClick(View v) {

    }
}