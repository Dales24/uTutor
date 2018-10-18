package com.dan.ututor.System;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout di;

    public class StudentHome {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.di);
            di = (DrawerLayout) findViewById(R.id.di);
            // need to figure out which librarys are avalaible  missing a class toggle
        }


    }
