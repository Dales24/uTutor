package com.dan.ututor.System;

import android.os.Bundle;

import com.dan.ututor.R;
import android.support.v7.app.AppCompatActivity;


public class TutorProfile extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
    }}

    private void writeNewUser(String age, String school, String firstName, Strign lastName, String location,
                              String description,double gpa, int rating,boolean online, String email, String password) {
        Person person = new Person(age, school, email, lastName, location, description, gpa, rating, online, password);
        mDatabase.child("person").child(userId).setValue(user);
    }
// one for online and location,setting and reseting email
//when other adds rating, when reset the profile