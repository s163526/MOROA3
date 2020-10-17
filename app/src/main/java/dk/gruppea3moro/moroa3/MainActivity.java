package dk.gruppea3moro.moroa3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment bottomBarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBarFragment = new bottomBarFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.bottomBarFL, bottomBarFragment)  // tom container i layout
                .commit();
    }
}