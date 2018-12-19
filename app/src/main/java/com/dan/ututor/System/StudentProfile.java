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
import com.google.firebase.database.ValueEventListener;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import 	android.support.design.widget.BottomNavigationView;
import android.widget.Spinner;
import android.widget.Toast;
public class StudentProfile extends AppCompatActivity {

    //global vars
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
    //start xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //find xml elements
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
//database reference
        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Students");
//        databaseReference.keepSynced(true);
        mBottomNavigation = (BottomNavigationView) findViewById(R.id.main_nav);
//navigation redirects onclick
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
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
                }

                return true;
            }
        });

// populating the users data
        if (mAuth.getCurrentUser() != null) {
            String user_id = mAuth.getCurrentUser().getUid();
            DatabaseReference user_db = databaseReference.child(user_id);
// database ref from user id
            user_db.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                // getting datasnap shot of info and setting text field
                    String name1 = dataSnapshot.child("Name").getValue().toString();
                    String age1 = dataSnapshot.child("Age").getValue().toString();
                    String GPA1 = dataSnapshot.child("GPA").getValue().toString();
                    String location1 = dataSnapshot.child("Location").getValue().toString();
                    String des1 = dataSnapshot.child("Description").getValue().toString();
                    String major1 = dataSnapshot.child("Major").getValue().toString();
                    String school1 = dataSnapshot.child("School").getValue().toString();
                    name.setText(name1);
                    gpa.setText(GPA1);
                    age.setText(age1);
                    location.setText(location1);
                    description.setText(des1);
                 /*   ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_state, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    major.setAdapter(adapter);
                    if (major1 != null) {
                        int spinnerPosition = adapter.getPosition(major1);
                        major.setSelection(spinnerPosition);
                    }*/

                    school.setText(school1);


                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
// saving info in database
            save.setOnClickListener((new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (mAuth.getCurrentUser() != null) {

                        String current_uid = mCurrentUser.getUid();

                        DatabaseReference user_db = databaseReference.child(current_uid);
// database ref from user id
                        //creating childs under id
                        user_db.child("Name").setValue(name.getText().toString().trim());
                        user_db.child("Age").setValue(age.getText().toString().trim());
                        user_db.child("Location").setValue(location.getText().toString().trim());
                        user_db.child("Description").setValue(description.getText().toString().trim());
                        user_db.child("GPA").setValue(gpa.getText().toString().trim());
                        user_db.child("School").setValue(school.getText().toString().trim());
                        user_db.child("Major").setValue(major.getSelectedItem().toString());
                        FirebaseUser user = mAuth.getCurrentUser();
                    } else {
                        Toast.makeText(StudentProfile.this, "Error ", Toast.LENGTH_LONG).show();
                    }
                }
            }));
        }

    }
}
