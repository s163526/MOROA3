package dk.gruppea3moro.moroa3;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


//TODO viewpager
public class FindEventFragment extends Fragment {
    TabFragmentAdapter tabFragmentAdapter;
    ViewPager2 viewPager;
    static TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_find_event, container, false);
        tabLayout = root.findViewById(R.id.findEventTabLayout);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabFragmentAdapter = new TabFragmentAdapter(this);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(tabFragmentAdapter);

        TabLayout tabLayout = view.findViewById(R.id.findEventTabLayout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) ->
                getTabText(tab, position)
        ).attach();
    }

    public void getTabText(TabLayout.Tab tab, int position) {
        switch (position) {
            case 0:
                tab.setText(getString(R.string.tabWhen));
                break;
            case 1:
                tab.setText(getString(R.string.tabCategory));
                break;
            case 2:
                tab.setText(getString(R.string.tabWhere));
                break;
            default:
                break;
        }
    }
/*
    public static void changeTabLayoutColor(int position) {
        switch (position) {
            case 0:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.moroSalmonRedBackground));
                break;
            case 1:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.moroYellowBackground));
                break;
            case 2:
                tabLayout.setBackgroundColor(getResources().getColor(R.color.moroPurpleBackground));
                break;

        }
    }*/
}

class TabFragmentAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    public TabFragmentAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new WhenTabFragment();
                break;
            case 1:
                fragment = new CategoryTabFragment();
                break;
            case 2:
                fragment = new WhereTabFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}