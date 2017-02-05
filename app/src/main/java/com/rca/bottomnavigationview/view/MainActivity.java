package com.rca.bottomnavigationview.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.rca.bottomnavigationview.R;
import com.rca.bottomnavigationview.view.adapter.FragmentAdapter;
import com.rca.bottomnavigationview.view.fragment.FadePageTransformer;
import com.rca.bottomnavigationview.view.fragment.FirstFragment;
import com.rca.bottomnavigationview.view.fragment.FifthFragment;
import com.rca.bottomnavigationview.view.fragment.FourthFragment;
import com.rca.bottomnavigationview.view.fragment.SecondFragment;
import com.rca.bottomnavigationview.view.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentAdapter adapter;

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        setupViewPager(viewPager);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int index = adapter.getIndexMenuItemId(item.getItemId());
            viewPager.setCurrentItem(index);
            return true;
        }
    };

    private void setupViewPager(ViewPager viewPager) {

        adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new FirstFragment(), "First Fragment", R.id.action_favorites);
        adapter.addFragment(new SecondFragment(), "Second Fragment", R.id.action_schedules);
        adapter.addFragment(new ThirdFragment(), "Third Fragment", R.id.action_music);
        adapter.addFragment(new FourthFragment(), "Fourth Fragment", R.id.action_music2);
        adapter.addFragment(new FifthFragment(), "Fifth Fragment", R.id.action_music3);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setPageTransformer(false, new FadePageTransformer(viewPager));
    }
}