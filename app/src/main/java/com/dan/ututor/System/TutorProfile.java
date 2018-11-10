package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;

import com.dan.ututor.Log;
import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import 	android.support.design.widget.BottomNavigationView;
import android.widget.Spinner;

public class TutorProfile extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private EditText school;
    private EditText age;
    private EditText name;
    private EditText location;
    private EditText description;
    private EditText gpa;
    private Spinner major;

    Button save;


    BottomNavigationView mBottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        name = (EditText) findViewById(R.id.name);
        school = (EditText) findViewById(R.id.school);
        age = (EditText) findViewById(R.id.age);
        location = (EditText) findViewById(R.id.location);
        description = (EditText) findViewById(R.id.description);
        gpa = (EditText) findViewById(R.id.gpa);
        major = (Spinner) findViewById(R.id.spinner1);

        save = (Button) findViewById(R.id.save);
            firebaseDatabase = FirebaseDatabase.getInstance();

            databaseReference = firebaseDatabase.getReference("Tutor");


        mBottomNavigation =(BottomNavigationView) findViewById(R.id.main_nav);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(TutorProfile.this, Searching.class);
                        startActivity(intent);
                        break;
                    case R.id.settings:
                        Intent intent2 = new Intent(TutorProfile.this, Settings.class);
                        startActivity(intent2);
                        break;
                    case R.id.help:
                        Intent intent3 = new Intent(TutorProfile.this, Help.class);
                        startActivity(intent3);
                        break;
                }

                return true;
            }});

        save.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                  String    key     = databaseReference.getKey();

                    databaseReference.child(key).child("Name").setValue(name.getText().toString().trim());
                     databaseReference.child(key).child("Age").setValue(age.getText().toString().trim());
                     databaseReference.child(key).child("Location").setValue(location.getText().toString().trim());
                     databaseReference.child(key).child("Description").setValue(description.getText().toString().trim());
                     databaseReference.child(key).child("GPA").setValue(gpa.getText().toString().trim());
                     databaseReference.child(key).child("School").setValue(school.getText().toString().trim());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }));
    }
}

// one for online and location,setting and resetting email
//when other adds rating, when reset the profile