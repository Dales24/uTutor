package com.dan.ututor.System;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dan.ututor.R;

public class StudentProfile extends AppCompatActivity{
 Person person = new Person();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        // Resetting profile info
        // viewing the data
        EditText editFirstName = (EditText) findViewByID(R.id.editText10);
        editFirstName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                boolean handled = false;
                if (i == EditorInfo.IME_ACTION_NEXT) {
                    String inputText = textView.getText().toString();
                    Toast.makeText(MainActivity.this, "First Name:" + inputText, Toast.LENGTH_SHORT).show();

                }}}}}
// one for online and location,setting and reseting email
        //when other adds rating, when reset the profile


