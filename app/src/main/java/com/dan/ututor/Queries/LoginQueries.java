package com.dan.ututor.Queries;

import android.widget.EditText;
import com.dan.ututor.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View;

public class LoginQueries {

    //declare DB
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference() ;

    public static void LoginStudent(View view){

        //Retrieve data from login page and convert to string
        EditText rawEmail = findViewById(R.id.emailInput);
        String stringEmail = rawEmail.getText().toString();

        EditText rawPass = findViewById(R.id.passwordInput);
        String stringPass = rawPass.getText().toString();


        //init DB


        //execute insertion of new user
        int ID=10000;
        Student st = new Student("test@gmail.com","pass1234",ID);
        dbRef.child("Students").child(Integer.toString(ID)).setValue(st);

    }
    public static void LoginTutor(View view){

    }


}