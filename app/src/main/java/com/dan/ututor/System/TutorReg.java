package com.dan.ututor.System;

import android.os.Bundle;

import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class TutorReg extends AppCompatActivity {

        Person person = new Person();

        private EditText school;
        private EditText age;
        private EditText name;
        private EditText location;
        private EditText description;
        private EditText gpa;
        private EditText major;
        Button save;
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_tutor);


            name = (EditText) findViewById(R.id.name);
            school = (EditText) findViewById(R.id.school);
            age = (EditText) findViewById(R.id.age);
            location = (EditText) findViewById(R.id.location);
            description = (EditText) findViewById(R.id.description);
            gpa = (EditText) findViewById(R.id.gpa);
            major = (EditText) findViewById(R.id.major);
            save = (Button) findViewById(R.id.save);

            firebaseDatabase = FirebaseDatabase.getInstance();

            databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/Tutors");

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DatabaseReference mChild = databaseReference.push();
// need to create major option button
                    mChild.child("Name").setValue(name.getText().toString().trim());
                    mChild.child("Age").setValue(age.getText().toString().trim());
                    mChild.child("Location").setValue(location.getText().toString().trim());
                    mChild.child("Description").setValue(description.getText().toString().trim());
                    mChild.child("GPA").setValue(gpa.getText().toString().trim());
                    mChild.child("School").setValue(school.getText().toString().trim());
                    mChild.child("Major").setValue(major.getText().toString().trim());
                    //need to send email verification
                }
            }}}





