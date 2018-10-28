package com.dan.ututor.System;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.dan.ututor.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Searching extends AppCompatActivity {

    public String bio="Biology";
    public String math="Math";
    public String nursing="Nursing";
    public String communications="Communications";
    public String bus="Business";
    public String criminaljust="Criminal Justice";
    public String sportssci="Sports Science";
    public String English="English";
    public String history="History";



    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }}
/*
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value  = dataSnapshot.getValue(String.class);
// need conditions
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    //    ListView listView = (ListView)findViewByID(R.id.listView);

    }}
/*
    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return profiles.length;
        }
        @Override
        public Object getItem(int i){
            return null;
        }
        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
            // need conditions
        }
    }}
// display interface

// button clic action events



   /* if(dropdown menu == subname){
       filter through tutors in that sub
       order by map
  select statement from the database
  // we need to figure out location implementatiokn here

    }
   */

