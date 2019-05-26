package com.example.hackathonapplication.Home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.hackathonapplication.MissionFragment;
import com.example.hackathonapplication.MsgFragment;
import com.example.hackathonapplication.R;
import com.example.hackathonapplication.UserFragment;
import com.example.hackathonapplication.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private String id;
    private Fragment MsgFragment;
    private Fragment UserFragment;
    private Fragment MissionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_mission);
        SharedPreferences sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        id=sharedPreferences.getString("id","");
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = findViewById(R.id.vp);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        MsgFragment=new MsgFragment();
        MissionFragment=new MissionFragment();
        UserFragment=new UserFragment();
        List<Fragment> list = new ArrayList<>();
        list.add(MissionFragment);
        list.add(MsgFragment);
        list.add(UserFragment);
        viewPagerAdapter.setList(list);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.navigation_mission:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_msg:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_User:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    public String getId(){
        return this.id;
    }
}
