package com.dan.ututor.System;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Button;
public class StudentProfile extends AppCompatActivity{


    private EditText school;
    private EditText age;
    private EditText firstName;
    private EditText lastName;
    private EditText location;
    private EditText description;
    private EditText gpa;
    Button save;
    FirebaseDatabase firebaseDatabase;
   DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);


   firstName = (EditText) findViewById(R.id.firstName);
   lastName = (EditText) findViewById(R.id.lastName);
   save = (Button) findViewById(R.id.save);

   firebaseDatabase = FirebaseDatabase.getInstance();

   databaseReference= firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/");

save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        DatabaseReference mChild= databaseReference.push();

        mChild.child("FirstName").setValue(firstName.getText().toString().trim());
        mChild.child("LastName").setValue(firstName.getText().toString().trim());
            }
        };








        // Resettng profile info
        // viewing the data

                //select user id and update information

                // we need to get all the stored info in person class
// writing and reading from the database

                //update user profile

                //update user profile rating


                //update user profile status


                //resetting a user email


// one for online and location,setting and reseting email
                //when other adds rating, when reset the profile


            }}