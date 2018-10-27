package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;

import com.dan.ututor.Log;
import com.dan.ututor.R;
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
import android.widget.Toast;

public class TutorReg extends AppCompatActivity {

    //    Person person = new Person();
FirebaseAuth mAuth;
        private EditText school;
        private EditText age;
        private EditText name;
        private EditText location;
        private EditText description;
        private EditText gpa;
        private EditText major;
        private EditText password;
        private EditText email;
        Button save;
        FirebaseDatabase firebaseDatabase;
        DatabaseReference databaseReference;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register_tutor);

            mAuth = FirebaseAuth.getInstance();
            name = (EditText) findViewById(R.id.name);
            school = (EditText) findViewById(R.id.school);
            age = (EditText) findViewById(R.id.age);
            location = (EditText) findViewById(R.id.location);
            description = (EditText) findViewById(R.id.description);
            gpa = (EditText) findViewById(R.id.gpa);
            major = (EditText) findViewById(R.id.major);
            email = (EditText) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);
            save = (Button) findViewById(R.id.save);
    //        firebaseDatabase = FirebaseDatabase.getInstance();

            databaseReference = firebaseDatabase.getInstance().getReference().child("Tutors");

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

              //      if(name!= null | email!= null | password!= null) {
                        DatabaseReference mChild = databaseReference.push();
                        String id  = databaseReference.getKey();
// need to create major option button
                        mChild.child("Name").setValue(name.getText().toString().trim());
                        mChild.child("Age").setValue(age.getText().toString().trim());
                        mChild.child("Location").setValue(location.getText().toString().trim());
                    mChild.child("Password").setValue(password.getText().toString().trim());
                    mChild.child("Email").setValue(email.getText().toString().trim());
                        mChild.child("Description").setValue(description.getText().toString().trim());
                        mChild.child("GPA").setValue(gpa.getText().toString().trim());
                        mChild.child("School").setValue(school.getText().toString().trim());


                          sendEmailVerification();

                 //   }
                 //   else {
                   //     Toast.makeText(this,"Error:" +error,Toast.LENGTH_SHORT).show();
                //    }
                }
            });
        }
            private void sendUserToLogin(){
                Intent intent = new Intent(TutorReg.this, Log.class);
                startActivity(intent);
                finish();
            }


        private void sendEmailVerification (){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            if(user != null){
   user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            FirebaseAuth.getInstance().signOut();
                            //  Toast.makeText(this,"Successful, verify account",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(TutorReg.this, Log.class);
                            startActivity(intent);
                            mAuth.signOut();
                        } else {
                            String error = task.getException().getMessage();
                            //  Toast.makeText(this,"Error:" +error,Toast.LENGTH_SHORT).show();
                            mAuth.signOut();
                        }
                    }

            });
            }
            }
        }





