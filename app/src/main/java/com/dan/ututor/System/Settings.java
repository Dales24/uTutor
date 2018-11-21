package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.annotation.NonNull;
import android.widget.SectionIndexer;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
public class Settings extends AppCompatActivity {
   Button deleteaccc;
    Button logout;
    Button reset;
    private EditText password;
    private EditText email;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
TutorReg reg = new TutorReg();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = (Button) findViewById(R.id.logout);
        reset = (Button) findViewById(R.id.reset);
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password2);
        deleteaccc = (Button) findViewById(R.id.deleteaccc);



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
                                                            Toast.makeText(Settings.this, "Sent", Toast.LENGTH_LONG).show();
                                                        }
                                                    }
                                                });

                                    }
                                    });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, Log.class);
                startActivity(intent);
                finish();
            }
    });
        deleteaccc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if(currentUser !=null){
                currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            startActivity(new Intent(Settings.this, Log.class));
                            finish();
                        } else {
                            Toast.makeText(Settings.this, "Error ", Toast.LENGTH_LONG).show();
                        }
                    }
                });}
            }



});
    }}

