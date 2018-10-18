package com.dan.ututor.System;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.Button;

import java.util.jar.Attributes;

public class StudentProfile extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/Students");
// mock need variables to replace tis

        try {

            databaseReference.child(ID).child("Name").setValue(name.getText().toString().trim());
            databaseReference.child("Age").setValue(age.getText().toString().trim());
            databaseReference.child("Location").setValue(location.getText().toString().trim());
            databaseReference.child("Description").setValue(description.getText().toString().trim());
            databaseReference.child("GPA").setValue(gpa.getText().toString().trim());
            databaseReference.child("School").setValue(school.getText().toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
