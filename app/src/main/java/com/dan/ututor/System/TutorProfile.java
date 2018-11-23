package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;

import com.dan.ututor.R;

import android.view.View;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import 	android.support.design.widget.BottomNavigationView;
import android.widget.Spinner;
import android.widget.Toast;

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
    private FirebaseAuth mAuth;
    Button save;

    Task<AuthResult> task;

    private FirebaseUser mCurrentUser;

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

        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();

        mAuth = FirebaseAuth.getInstance();

databaseReference = FirebaseDatabase.getInstance().getReference().child("Tutors");
//        databaseReference.keepSynced(true);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.main_nav);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
            }
        });
/*
        if (mAuth.getCurrentUser() != null) {
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference user_db = databaseReference.child(user_id);

            user_db.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                    if (mAuth.getCurrentUser() != null) {

                        String UserUserName = String.valueOf(dataSnapshot.child("Name").getValue());
                        name.setText(UserUserName);
                    }

                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        } */
        save.setOnClickListener((new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(mAuth.getCurrentUser() !=null) {

                            String current_uid = mCurrentUser.getUid();

                            DatabaseReference user_db = databaseReference.child(current_uid);

                            user_db.child("Name").setValue(name.getText().toString().trim());
                            user_db.child("Age").setValue(age.getText().toString().trim());
                            user_db.child("Location").setValue(location.getText().toString().trim());
                            user_db.child("Description").setValue(description.getText().toString().trim());
                            user_db.child("GPA").setValue(gpa.getText().toString().trim());
                            user_db.child("School").setValue(school.getText().toString().trim());
                            user_db.child("Major").setValue(major.getSelectedItem().toString());
                            FirebaseUser    user    =  mAuth.getCurrentUser();
                    }
                        else {
                            Toast.makeText(TutorProfile.this, "Error ", Toast.LENGTH_LONG).show();
                        }
                    }
                }));
            }


        }
