package dk.gruppea3moro.moroa3.model;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;

import java.util.ArrayDeque;
import java.util.Deque;
import com.google.gson.Gson;

import dk.gruppea3moro.moroa3.AboutUsFragment;
import dk.gruppea3moro.moroa3.ContactUsFragment;
import dk.gruppea3moro.moroa3.FindEventFragment;
import dk.gruppea3moro.moroa3.FrontpageFragment;
import dk.gruppea3moro.moroa3.MenuFragment;
import dk.gruppea3moro.moroa3.MyProfileFragment;
import dk.gruppea3moro.moroa3.R;
import dk.gruppea3moro.moroa3.ShowEventFragment;
import dk.gruppea3moro.moroa3.ShowResultFragment;
import dk.gruppea3moro.moroa3.TipUsFragment;

import static android.content.Context.MODE_PRIVATE;

public class AppState extends Application {
    private static AppState instance;
    private Deque<Integer> integerDeque = new ArrayDeque<>(5);



    //STATIC METHODS--------------------------------------------------------------------------------
    public static AppState get(){
        if (instance==null){
            instance=new AppState();
        }
        return instance;
    }

    //Returns layout id of the fragment corresponding to the item selected in bottom navigation bar
    public static int getFragmentLayoutId(int bnItemId) {
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

    public static Fragment getFragmentFromLayoutId(int layoutId) {
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

    //NON STATIC METHODS----------------------------------------------------------------------------


    public void saveToPM(Context context){
        SharedPreferences mPrefs = context.getSharedPreferences("AppState",MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(get());
        prefsEditor.putString("AppState", json);
        prefsEditor.commit();
    }

    public void readFromPM(Context context){
        SharedPreferences mPrefs = context.getSharedPreferences("AppState",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("AppState", "");
        instance = gson.fromJson(json, AppState.class);
        System.out.println("");
    }



    public Deque<Integer> getIntegerDeque() {
        return integerDeque;
    }

    public void onCreate() {
        super.onCreate();
        //clear instance
        instance = new AppState();
        //Save instance
        saveToPM(getApplicationContext());
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