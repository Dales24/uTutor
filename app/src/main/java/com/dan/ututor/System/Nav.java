package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.dan.ututor.R;

public class Nav extends AppCompatActivity {
//global vars
    private BottomNavigationView mMainNav;
    private FrameLayout  mMainFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

//getting xml elements
        mMainFrame = (FrameLayout)findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);


//redirects based on button clicks
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch(item.getItemId()){

                   case R.id.profile:{

                   Intent intent = new Intent(Nav.this, StudentProfile.class);
                   startActivity(intent);
                   finish();
                       return true;}
                   case R.id.settings: {
                       Intent intent = new Intent(Nav.this, Settings.class);
                       startActivity(intent);
                       finish();
                       return true;
                   }
                   case R.id.home: {
                       Intent intent = new Intent(Nav.this, Searching.class);
                       startActivity(intent);
                       finish();
                       return true;
                   }
                   case R.id.help: {
                       Intent intent = new Intent(Nav.this, StudentHome.class);
                       startActivity(intent);
                       finish();
                       return true;
                   }
                       default:
                           return false;
               }

               }
            });



        }
    }
