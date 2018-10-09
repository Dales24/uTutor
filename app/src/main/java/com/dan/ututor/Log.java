package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.dan.ututor.Queries.LoginQueries;
import 	android.content.Intent;
import com.dan.ututor.Queries.LoginQueries;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Log extends AppCompatActivity {
    Button login;
    Button reset;
    Button registerstudent;
    Button registertutor;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    login = (Button) findViewById(R.id.login);
        reset = (Button) findViewById(R.id.reset);
        registerstudent = (Button) findViewById(R.id.registerstudent);
        registertutor = (Button) findViewById(R.id.registertutor);
    firebaseDatabase = FirebaseDatabase.getInstance();
    databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/");

        login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         // need verification condition

           if() {
               Intent intent = new Intent(this,TutorHome.class);
           }
           else

               Intent intent = new Intent(this, StudentHome.class);

    }
}
            reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      Intent intent = new Intent(this, Reset.class);
                      startActivity(intent);
                        }}

                    registerstudent.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(this, StudentReg.class);
                                startActivity(intent);
                            }
                        }

                            registertutor.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(this, TutorReg.class);
                                    startActivity(intent);
                                }
                            }


    }}