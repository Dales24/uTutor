package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.dan.ututor.Queries.LoginQueries;

import com.dan.ututor.Queries.LoginQueries;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClicked(View view){

        //Retrieve login type from radio buttons

        String personType="";
        CompoundButton studentRadio =  findViewById(R.id.radioStudent);
        CompoundButton tutorRadio =  findViewById(R.id.radioTutor);

        if(studentRadio.isChecked())
        {
            LoginQueries.LoginStudent(view);
        }
        else if(tutorRadio.isChecked())
        {
            LoginQueries.LoginTutor(view);
        }

    }
}