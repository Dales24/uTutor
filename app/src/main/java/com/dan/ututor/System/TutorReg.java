package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;


import com.dan.ututor.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import android.text.TextUtils;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.AuthResult;
public class TutorReg extends AppCompatActivity {


//global vars
    //    Person person = new Person();

    private FirebaseAuth mAuth;
        private EditText school;
        private EditText age;
        private EditText name;
        private EditText location;
        private EditText description;
        private EditText gpa;
        private Spinner major;
        private EditText password;
        private EditText email;
        Button save;
        String ids;
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;
    public String getIDs(){return ids;}
    FirebaseAuth  firebaseAuth;
    //start xml
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_tutor);
//find elements and save

            name = (EditText) findViewById(R.id.name);
            school = (EditText) findViewById(R.id.school);
            age = (EditText) findViewById(R.id.age);
            location = (EditText) findViewById(R.id.location);
            description = (EditText) findViewById(R.id.description);
            gpa = (EditText) findViewById(R.id.gpa);
            major = (Spinner) findViewById(R.id.spinner1);
            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password2);
            save = (Button) findViewById(R.id.save);
         firebaseDatabase = FirebaseDatabase.getInstance();

            String email2=email.getText().toString().trim();
            mAuth = FirebaseAuth.getInstance();
            databaseReference = firebaseDatabase.getReference().child("Tutors");

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        sendEmailVerification();

                    }

//send ver


                private void sendEmailVerification() {
                    String email2 = email.getText().toString();
                    String password2 = password.getText().toString();
//local vars for email and password check 
                    String name2 = name.getText().toString();
                    if(!TextUtils.isEmpty(name2) && !TextUtils.isEmpty(email2) && !TextUtils.isEmpty(password2)) {
                        mAuth.createUserWithEmailAndPassword(email2, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
//create  a new user
                                if (task.isSuccessful()) {
                                    if (mAuth.getCurrentUser() != null) {
                                        String user_id = mAuth.getCurrentUser().getUid();

                                        DatabaseReference user_db = databaseReference.child(user_id);
// set childs
                                        user_db.child("Name").setValue(name.getText().toString().trim());
                                        user_db.child("Age").setValue(age.getText().toString().trim());
                                        user_db.child("Location").setValue(location.getText().toString().trim());
                                        user_db.child("Description").setValue(description.getText().toString().trim());
                                        user_db.child("GPA").setValue(gpa.getText().toString().trim());
                                        user_db.child("School").setValue(school.getText().toString().trim());
                                        user_db.child("Major").setValue(major.getSelectedItem().toString());
                                        user_db.child("Email").setValue(email.getText().toString());
                                        user_db.child("UID").setValue(user_id);
                              FirebaseUser    user    =  mAuth.getCurrentUser();
                            //send email ver based on user object
                                        if(mAuth.getCurrentUser() != null)
                                        user.sendEmailVerification()
                                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Intent intent = new Intent(TutorReg.this, com.dan.ututor.System.Log.class);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    }
                                                });


                                    }
                                }

                            }
                        });


                    }
                            }




});}}





