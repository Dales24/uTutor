package com.dan.ututor.System;

import android.os.Bundle;

import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class TutorProfile extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/Tutors");

        try {
            databaseReference.child("myDb").child("awais@gmailcom").child("leftSpace").setValue("YourDateHere");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// one for online and location,setting and resetting email
//when other adds rating, when reset the profile