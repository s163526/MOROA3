package dk.gruppea3moro.moroa3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        integerDeque.push(R.id.fragment_frontpage);
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
                        int fragmentId = getFragmentLayoutId(id);

                        //Push fragment id to backstack deque
                        pushToBackstackDequeTop(fragmentId);

                        //load fragment
                        loadFragment(getFragmentFromLayoutId(fragmentId));
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


    //Returns layout id of the fragment corresponding to the item selected in bottom navigation bar
    public int getFragmentLayoutId(int bnItemId) {
        switch (bnItemId){
            case R.id.bn_home:
                return R.id.fragment_frontpage;
            case R.id.bn_right_now:
                return R.id.fragment_right_now;
            case R.id.bn_find_event:
                return R.id.fragment_find_event;
            case R.id.bn_my_profile:
                return R.id.fragment_my_profile;
            case R.id.bn_menu:
                return R.id.fragment_menu;
            default:
                //Indicate that something went wrong
                return 1;
        }
    }

    public Fragment getFragmentFromLayoutId(int layoutId) {
        switch (layoutId) {
            case R.id.fragment_frontpage:
                return new FrontpageFragment();
            case R.id.fragment_right_now:
                return new ShowEventFragment();
            case R.id.fragment_show_result:
                return new ShowResultFragment();
            case R.id.fragment_find_event:
                return new FindEventFragment();
            case R.id.fragment_my_profile:
                return new MyProfileFragment();
            case R.id.fragment_menu:
                return new MenuFragment();
            case R.id.fragment_contact_us:
                return new ContactUsFragment();
            case R.id.fragment_tip_us:
                return new TipUsFragment();
            case R.id.fragment_about_us:
                return new AboutUsFragment();
            default:
                //If something went wrong
                return new FrontpageFragment();
        }
    }


    //Use to change between fragments and set the bottom navigation bar at the same time.
    //Only usable for fragments, that are present on bottom navigation bar
    public void setBottonNavSelection(int fragmentId) {
        switch (fragmentId){
            case R.id.fragment_frontpage:
                //Set checked frontpage
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                break;
            case R.id.fragment_right_now:
                //Set checked right now
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                break;
            case R.id.fragment_find_event:
            //case R.id.fragment_category_tab:
            //case R.id.fragment_when_tab:
            //case R.id.fragment_where_tab:
                //Set checked find event
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                break;
            case R.id.fragment_my_profile:
                //Set checked my profile
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                break;
            case R.id.fragment_menu:
            case R.id.fragment_about_us:
            case R.id.fragment_contact_us:
            case R.id.fragment_tip_us:
               //Set checked menu
                bottomNavigationView.getMenu().getItem(4).setChecked(true);
                break;
            default:
                //If it's not one of the bottom-nav fragments - do nothing
        }
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
            int id = integerDeque.peek();
            setBottonNavSelection(id);
            loadFragment(getFragmentFromLayoutId(id));
        } else {
            //When deque list is empty
            //Finish activity
            finish();
        }
    }




    @Override
    public void onClick(View v) {

    }

    public void pushToBackstackDequeTop(int fragmentID){
        //Get selected item id
        if (integerDeque.contains(fragmentID)){
            //If deque already contains the item - remove
            integerDeque.remove(fragmentID);
        }

        //Push selected id in deque list - so it is on top
        integerDeque.push(fragmentID);
        //load fragment
    }
}