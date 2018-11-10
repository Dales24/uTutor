package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Settings extends AppCompatActivity {

    Button logout;
    Button reset;
    private EditText password;
    private EditText email;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = (Button) findViewById(R.id.logout);
        reset = (Button) findViewById(R.id.reset);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);



        firebaseDatabase = FirebaseDatabase.getInstance();


        databaseReference = firebaseDatabase.getReference().child("Tutors");

        reset.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        DatabaseReference mChild = databaseReference.push();


                                        mChild.child("Password").setValue(password.getText().toString().trim());
                                        mChild.child("Email").setValue(email.getText().toString().trim());

                                            Intent intent = new Intent(Settings.this, com.dan.ututor.Log.class);
                                            startActivity(intent);
                                            finish();

                                    }
                                    });
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, com.dan.ututor.Log.class);
                startActivity(intent);
                finish();
            }
    });
}
}
// resetting email
//logging out
