package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;

import com.dan.ututor.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import 	android.support.design.widget.BottomNavigationView;
import android.widget.Spinner;
import android.widget.Toast;


public class StudentProfile extends AppCompatActivity {

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
        setContentView(R.layout.activity_student_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Students");


        mBottomNavigation = (BottomNavigationView) findViewById(R.id.main_nav);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Intent intent = new Intent(StudentProfile.this, Searching.class);
                        startActivity(intent);
                        break;
                    case R.id.settings:
                        Intent intent2 = new Intent(StudentProfile.this, Settings.class);
                        startActivity(intent2);
                        break;
                    case R.id.help:
                        Intent intent3 = new Intent(StudentProfile.this, Help.class);
                        startActivity(intent3);
                        break;
                    case R.id.home:
                        Intent intent4 = new Intent(StudentProfile.this, StudentHome.class);
                        startActivity(intent4);
                        break;
                }

                return true;
            }
        });

    if (mAuth.getCurrentUser() != null) {
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference user_db = databaseReference.child(user_id);

            user_db.addChildEventListener(new ChildEventListener() {
@Override
public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


        if (mAuth.getCurrentUser() != null) {
        String  name1  =  dataSnapshot.child("Name").toString();

        name.setText(name1);
        age.setText(dataSnapshot.child("Age").getValue(String.class));
        location.setText(dataSnapshot.child("Location").getValue(String.class));
        //   major.setText("Major");
        description.setText(dataSnapshot.child("Description").getValue(String.class));
        school.setText(dataSnapshot.child("School").getValue(String.class));
        gpa.setText(dataSnapshot.child("GPA").getValue(String.class));
        }

        }
@Override
public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }
@Override
public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }
public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {}
@Override
public void onCancelled(DatabaseError databaseError) {
        Toast.makeText(StudentProfile.this, "Error ", Toast.LENGTH_LONG).show();
        }
        });

        }
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
        Toast.makeText(StudentProfile.this, "Error ", Toast.LENGTH_LONG).show();
        }
        }
        }));
        }


        }
