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

        databaseReference = firebaseDatabase.getReference("Tutor");

        try {
            //         databaseReference.child(ID).child("Name").setValue(name.getText().toString().trim());
            //     databaseReference.child("Age").setValue(age.getText().toString().trim());
            //       databaseReference.child("Location").setValue(location.getText().toString().trim());
            //        databaseReference.child("Description").setValue(description.getText().toString().trim());
            //      databaseReference.child("GPA").setValue(gpa.getText().toString().trim());
            //      databaseReference.child("School").setValue(school.getText().toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// one for online and location,setting and resetting email
//when other adds rating, when reset the profile