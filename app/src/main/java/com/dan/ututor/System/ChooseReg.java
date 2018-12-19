package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dan.ututor.R;

public class ChooseReg extends AppCompatActivity {
    Button registerstudent;
    Button registertutor;
    Button back;
//start xml
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosereg);
        back = (Button) findViewById(R.id.back);
        registerstudent = (Button) findViewById(R.id.registerstudent);
        registertutor = (Button) findViewById(R.id.registertutor);
// on click to redirect to correct page
        registertutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseReg.this, TutorReg.class);
                startActivity(intent);
                finish();
            }
        });

        registerstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseReg.this, StudentReg.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseReg.this, Log.class);
                startActivity(intent);
                finish();
            }
        });

    }
}