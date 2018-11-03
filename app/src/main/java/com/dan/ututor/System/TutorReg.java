package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;


import com.dan.ututor.R;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.auth.AuthResult;
public class TutorReg extends AppCompatActivity {



    //    Person person = new Person();

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
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;

    FirebaseAuth  firebaseAuth;
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
            major = (Spinner) findViewById(R.id.spinner1);
            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            save = (Button) findViewById(R.id.save);
         firebaseDatabase = FirebaseDatabase.getInstance();



            databaseReference = firebaseDatabase.getReference().child("Tutors");

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //      if(name!= null | email!= null | password!= null) {
                    DatabaseReference mChild = databaseReference.push();
                    String id = databaseReference.getKey();
                    // need to create major option button
                    mChild.child("Name").setValue(name.getText().toString().trim());
                    mChild.child("Age").setValue(age.getText().toString().trim());
                    mChild.child("Location").setValue(location.getText().toString().trim());
                    mChild.child("Password").setValue(password.getText().toString().trim());
                    mChild.child("Email").setValue(email.getText().toString().trim());
                    mChild.child("Description").setValue(description.getText().toString().trim());
                    mChild.child("GPA").setValue(gpa.getText().toString().trim());
                    mChild.child("School").setValue(school.getText().toString().trim());
                    mChild.child("Major").setValue(major.getSelectedItem().toString());
           //   sendEmailVerification();






                                        }




                private void sendUserToLogin() {
                    Intent intent = new Intent(TutorReg.this, Log.class);
                    startActivity(intent);
                    finish();

                }


                private void sendEmailVerification() {

                    firebaseAuth= FirebaseAuth.getInstance();
                    String email2 = email.getText().toString();
                    String password2 = password.getText().toString();
                    firebaseAuth.createUserWithEmailAndPassword(email2, password2)
                            .addOnCompleteListener(TutorReg.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                            user.sendEmailVerification()
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            user.sendEmailVerification();
                                                            if (task.isSuccessful()) {
                                                                finish();
                                                                Toast.makeText(TutorReg.this, "Registered Successfully. Check your email", Toast.LENGTH_SHORT).show();
                                                                startActivity(new Intent(getApplicationContext(), Log.class));
                                                            }
                                                        }
                                                    });

                                            if (firebaseAuth.getCurrentUser() != null) {
                                                finish();
                                                startActivity(new Intent(getApplicationContext(), Log.class));
                                            }
                                        } else {
                                            Toast.makeText(TutorReg.this, "Could not Register User. Try Again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
});}});}}





