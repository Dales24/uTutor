package com.dan.ututor.System;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.dan.ututor.R;

public class Nav extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout  mMainFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);


        mMainFrame = (FrameLayout)findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);



        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch(item.getItemId()){

                   case R.id.profile:
                       return true;
                   case R.id.settings:
                       return true;
                   case R.id.home:
                       return true;
                   case R.id.help:

                       return true;
                       default:
                           return false;
               }

               }
            });



        }
    }
