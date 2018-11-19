package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import 	android.content.Intent;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.dan.ututor.System.Settings;
import com.dan.ututor.System.StudentReg;
import com.dan.ututor.System.TutorReg;
import com.dan.ututor.System.StudentProfile;
import com.dan.ututor.System.TutorProfile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import com.google.android.gms.auth.api.Auth;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Log extends AppCompatActivity {
private EditText password;
private EditText email;
Button login;
Button reset;

Button registerstudent;
Button registertutor;
FirebaseAuth mAuth;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
DatabaseReference databaseReference2;
private Boolean emailCheck;
;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_login);
mAuth = FirebaseAuth.getInstance();
login = (Button) findViewById(R.id.login);
reset = (Button) findViewById(R.id.reset);
email = (EditText) findViewById(R.id.email);
password = (EditText) findViewById(R.id.password);
registerstudent = (Button) findViewById(R.id.registerstudent);
registertutor = (Button) findViewById(R.id.registertutor);
firebaseDatabase = FirebaseDatabase.getInstance();

databaseReference = firebaseDatabase.getReference("Students");
databaseReference2   =   firebaseDatabase.getReference("Tutors");
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       {
            // need verification condition
           Intent intent = new Intent(Log.this, TutorProfile.class);
           startActivity(intent);
           finish();


        }
           // verifyEmail();

    }
});
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Log.this, Settings.class);
        startActivity(intent);
        finish();
    }
});

registerstudent.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Log.this, StudentReg.class);
        startActivity(intent);
        finish();
    }
});

registertutor.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Log.this, TutorReg.class);
        startActivity(intent);
        finish();
    }
});
}





private void checkLogin() {

    String email2 = email.getText().toString();
    String password2 = password.getText().toString();

if(!TextUtils.isEmpty(email2) && !TextUtils.isEmpty(password2)) {


    mAuth.signInWithEmailAndPassword(email2, password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {

            if (task.isSuccessful()) {


                checkUserExist();

            } else {


                Toast.makeText(Log.this, "Error Login", Toast.LENGTH_LONG).show();

            }

        }
    });}}

private void checkUserExist()
    {

    if(mAuth.getCurrentUser() != null) {

        final String user_id = mAuth.getCurrentUser().getUid();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.hasChild(user_id)) {

                    Intent intent = new Intent(Log.this, TutorProfile.class);
                    startActivity(intent);
                    finish();

                } else {

                    Toast.makeText(Log.this, "Error Login", Toast.LENGTH_LONG).show();

                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

}

}}
