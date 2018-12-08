package com.dan.ututor.System;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TutorHome extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    FirebaseDatabase firebaseDatabase;
    private TextView name;
    private TextView location;
    private TextView major;
    private TextView description;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_home);
        name = findViewById(R.id.name);
        location= findViewById(R.id.loc);
       major = findViewById(R.id.maj);
        description = findViewById(R.id.des);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Relation");
        databaseReference.keepSynced(true);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            String user_id = mAuth.getCurrentUser().getUid();

            databaseReference.orderByChild("Tutor").equalTo(user_id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot datas : dataSnapshot.getChildren()) {
                        String keys = datas.getKey();
                        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Students").child(keys);
                String sName     =  databaseReference2.child("Name").toString();

                        System.out.println("testing " + sName);
                        sendName(databaseReference2);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {


                }
            });
        }}
            private void sendName (  DatabaseReference databaseReference2){
                System.out.println("testing " + databaseReference2);
                databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String sName = dataSnapshot.child("Name").getValue(String.class);
                        String location1 = dataSnapshot.child("Location").getValue(String.class);
                        String descrip = dataSnapshot.child("Description").getValue(String.class);
                        String major1 = dataSnapshot.child("Major").getValue(String.class);
                        name.setText(sName);
                        location.setText(location1);
                        major.setText(major1);
                        description.setText(descrip);
                        System.out.println("testing " + sName);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }
