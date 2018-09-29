package com.dan.ututor.System;

import android.os.Bundle;

import com.dan.ututor.R;
import android.support.v7.app.AppCompatActivity;


public class TutorProfile extends AppCompatActivity{
Person person = new Person();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
    }}

// one for online and location,setting and resetting email
//when other adds rating, when reset the profile