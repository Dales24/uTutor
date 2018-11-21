package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
public class SettingsLog extends AppCompatActivity {

    Button reset;
    private EditText password;
    private EditText email;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    TutorReg reg = new TutorReg();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsfromlogin);
        reset = (Button) findViewById(R.id.reset);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password2);




        firebaseDatabase = FirebaseDatabase.getInstance();
        String email2=email.getText().toString().trim();

        databaseReference = firebaseDatabase.getReference().child("Tutors").child(email2);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2=email.getText().toString().trim();
                FirebaseAuth.getInstance().sendPasswordResetEmail(email2)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SettingsLog.this, "Sent", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(SettingsLog.this, com.dan.ututor.System.Log.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });

            }
        });

    }}

