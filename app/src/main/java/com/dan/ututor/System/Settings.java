package com.dan.ututor.System;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dan.ututor.R;

public class Settings extends AppCompatActivity {

    Button logout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = (Button) findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, com.dan.ututor.Log.class);
                startActivity(intent);
                finish();
            }
    });
}
}
// resetting email
//logging out
