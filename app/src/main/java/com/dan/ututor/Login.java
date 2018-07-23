package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.dan.ututor.Student.Student;
import com.dan.ututor.Student.Tutor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    //declare DB
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClicked(View view){

        //Retrieve data from login page and convert to strings
        EditText rawPass = findViewById(R.id.passwordInput);
        String stringPass = rawPass.getText().toString();

        EditText rawEmail = findViewById(R.id.emailInput);
        String stringEmail = rawEmail.getText().toString();

        //init DB
        dbRef = FirebaseDatabase.getInstance().getReference();

        //execute insertion of new user
        int ID=10000;
        Student st = new Student("test@gmail.com","pass1234",ID);
        dbRef.child("Students").child(Integer.toString(ID)).setValue(st);

        ID=10001;
        st = new Student("test1@gmail.com","pass9999",ID);
        dbRef.child("Students").child(Integer.toString(ID)).setValue(st);

        ID=10002;
        Tutor tu = new Tutor("tes2@gmail.com","passxxx",ID);
        dbRef.child("Tutors").child(Integer.toString(ID)).setValue(tu);

        ID=10003;
        tu = new Tutor("test3@gmail.com","passyyy",ID);
        dbRef.child("Tutors").child(Integer.toString(ID)).setValue(tu);

    }
}
