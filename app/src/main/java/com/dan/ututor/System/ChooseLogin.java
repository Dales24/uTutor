package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dan.ututor.R;

public class ChooseLogin extends AppCompatActivity {
    Button tutorlog;
    Button studentlog;
    Button back;
//start xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choselogin);
        back = (Button) findViewById(R.id.back);
        studentlog = (Button) findViewById(R.id.studentlog);
        tutorlog = (Button) findViewById(R.id.tutorlog);
// on click to redirect to correct page
        tutorlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLogin.this, LoginTutor.class);
                startActivity(intent);
                finish();
            }
        });

        studentlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLogin.this, LogStudent.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLogin.this, Log.class);
                startActivity(intent);
                finish();
            }
        });

    }
}