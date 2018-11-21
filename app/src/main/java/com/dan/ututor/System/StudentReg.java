package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;

import com.dan.ututor.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class StudentReg extends AppCompatActivity {

    //    Person person = new Person();
    FirebaseAuth mAuth;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        mAuth = FirebaseAuth.getInstance();
        name = (EditText) findViewById(R.id.name);
        school = (EditText) findViewById(R.id.school);
        age = (EditText) findViewById(R.id.age);
        location = (EditText) findViewById(R.id.location);
        description = (EditText) findViewById(R.id.description);
        gpa = (EditText) findViewById(R.id.gpa);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password2);
        save = (Button) findViewById(R.id.save);
        //        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getInstance().getReference().child("Students");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendEmailVerification();

                //   }
                //   else {
                //     Toast.makeText(this,"Error:" +error,Toast.LENGTH_SHORT).show();
                //    }
            }
        });
    } private void sendEmailVerification() {
        String email2 = email.getText().toString();
        String password2 = password.getText().toString();

        String name2 = name.getText().toString();
        if(!TextUtils.isEmpty(name2) && !TextUtils.isEmpty(email2) && !TextUtils.isEmpty(password2)) {
            mAuth.createUserWithEmailAndPassword(email2, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        if (mAuth.getCurrentUser() != null) {
                            String user_id = mAuth.getCurrentUser().getUid();

                            DatabaseReference user_db = databaseReference.child(user_id);

                            user_db.child("Name").setValue(name.getText().toString().trim());
                            user_db.child("Age").setValue(age.getText().toString().trim());
                            user_db.child("Location").setValue(location.getText().toString().trim());
                            user_db.child("Description").setValue(description.getText().toString().trim());
                            user_db.child("GPA").setValue(gpa.getText().toString().trim());
                            user_db.child("School").setValue(school.getText().toString().trim());
                            user_db.child("Major").setValue(major.getSelectedItem().toString());

                            Intent intent = new Intent(StudentReg.this, Log.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                }
            });


        }
    }




}

