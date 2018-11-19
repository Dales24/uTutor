package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        deleteaccc = (Button) findViewById(R.id.deleteaccc);



        firebaseDatabase = FirebaseDatabase.getInstance();
        String email2=email.getText().toString().trim();

        databaseReference = firebaseDatabase.getReference().child("Tutors").child(email2);

        reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                               //    mAuth.sendPasswordResetEmail()

                                    }
                                    });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, com.dan.ututor.Log.class);
                startActivity(intent);
                finish();
            }
    });
        deleteaccc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        mAuth.getCurrentUser().delete();
}
});
    }}

