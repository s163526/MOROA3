package dk.gruppea3moro.moroa3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

//TODO burgermenu(kontakt os osv), søge menu med filtre, evt?
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    BottomNavigationView bottomNavigationView;

    public Deque<Integer> getIntegerDeque() {
        return integerDeque;
    }

    private Deque<Integer> integerDeque = new ArrayDeque<>(5);
    Fragment mainFragment, topBarFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Top bar.
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
        bottomNavigationView = findViewById(R.id.bottomnavigation);

        //Add home fragment in deque list
        integerDeque.push(R.id.bn_home);
        //Load home fragment
        loadFragment(new FrontpageFragment());
        //Set home as default fragment
        bottomNavigationView.setSelectedItemId(R.id.bn_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //Get selected item id
                        int id = item.getItemId();
                        if (integerDeque.contains(id)){
                            //If deque already contains the item - remove
                            integerDeque.remove(id);
                        }
                        //Push selected id in deque list - so it is on top
                        integerDeque.push(id);
                        //load fragment
                        loadFragment(getFragment(item.getItemId()));
                        return true;
                    }
                }
        );

        //Get rid of support action bar in top (Telling name of the app)
        getSupportActionBar().hide();

        //Set color of android's own statusbar in top.
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlackBackground));
        }

        //Change color of android's own navigation bar, so it matches our navigation bar
        //Only if android version is compatible
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorBlackBackground));
        }
    }

    public Fragment getFragment(int itemId) {
        switch (itemId){
            case R.id.bn_home:
                //Set checked dashboard fragment
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                return new FrontpageFragment();
            case R.id.bn_right_now:
                //Set checked home fragment
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                return new ShowEventFragment(); // TODO ændre til lige nu
            case R.id.bn_find_event:
                //Set checked Notification fragment
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                return new FindEventFragment();
            case R.id.bn_my_profile:
                //Set checked Notification fragment
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                return new FrontpageFragment(); //TODO ændre til profil (min side)
            case R.id.bn_menu:
                //Set checked Notification fragment
                bottomNavigationView.getMenu().getItem(4).setChecked(true);
                return new MenuFragment();
        }
        //Set checked default home fragment
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        //Return home fragment
        return new FrontpageFragment();
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFL,fragment)
                .commit();
    }

    public void onBackPressed(){
        //Pop to previous fragment
        integerDeque.pop();
        if(!integerDeque.isEmpty()){
            //When deque is not empty
            //load fragment
            loadFragment(getFragment(integerDeque.peek()));
        } else {
            //When deque list is empty
            //Finish activity
            finish();
        }
    }




    @Override
    public void onClick(View v) {

    }
}