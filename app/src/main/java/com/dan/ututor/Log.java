package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import 	android.content.Intent;
import android.widget.Toast;


import com.dan.ututor.System.Settings;
import com.dan.ututor.System.StudentReg;
import com.dan.ututor.System.TutorReg;
import com.dan.ututor.System.StudentProfile;
import com.dan.ututor.System.TutorProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Log extends AppCompatActivity {

    Button login;
    Button reset;
    Button registerstudent;
    Button registertutor;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private Boolean emailCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.login);
        reset = (Button) findViewById(R.id.reset);
        registerstudent = (Button) findViewById(R.id.registerstudent);
        registertutor = (Button) findViewById(R.id.registertutor);

     //   firebaseDatabase = FirebaseDatabase.getInstance();
      //  databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // need verification condition

                Intent intent = new Intent(Log.this, TutorProfile.class);
                startActivity(intent);
                finish();
                   // verifyEmail();

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log.this, Settings.class);
                startActivity(intent);
                finish();
            }
        });

        registerstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log.this, StudentReg.class);
                startActivity(intent);
                finish();
            }
        });

        registertutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log.this, TutorReg.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private boolean verifyEmail(){
        FirebaseUser user = mAuth.getCurrentUser();
        emailCheck = user.isEmailVerified();
        if(emailCheck==true){
         return true;
            }



else{
            Toast.makeText(this,"Please Verify Account",Toast.LENGTH_SHORT).show();
            mAuth.signOut();
            return false;
        }
    }}