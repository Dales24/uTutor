package com.dan.ututor.System;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import 	android.content.Intent;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class Log extends AppCompatActivity {
private EditText password;
private EditText email;
Button login;
Button register;

Button registerstudent;
Button registertutor;
FirebaseAuth mAuth;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
DatabaseReference databaseReference2;
private Boolean emailCheck;
;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);

login = (Button) findViewById(R.id.login);
register = (Button) findViewById(R.id.register);

firebaseDatabase = FirebaseDatabase.getInstance();
    databaseReference = FirebaseDatabase.getInstance().getReference().child("Tutors");
    databaseReference.keepSynced(true);
    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Log.this, ChooseLogin.class);
            startActivity(intent);
            finish();
        }
    });
    register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Log.this, ChooseReg.class);
            startActivity(intent);
            finish();
        }
    });

}
}

