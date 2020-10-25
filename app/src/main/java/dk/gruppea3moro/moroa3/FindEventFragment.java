package dk.gruppea3moro.moroa3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


//TODO viewpager
public class FindEventFragment extends Fragment {
    TabFragmentAdapter tabFragmentAdapter;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_find_event, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabFragmentAdapter = new TabFragmentAdapter(this);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(tabFragmentAdapter);
    }
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