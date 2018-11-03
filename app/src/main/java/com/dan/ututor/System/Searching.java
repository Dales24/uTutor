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
import 	java.util.ArrayList;
import 	android.widget.ArrayAdapter;
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

    ListView listView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference  = firebaseDatabase.getReference();

        listView = findViewById(R.id.listView);}}

/*
        private void showData() {

            databaseReference = firebaseDatabase.getInstance().getReference().child("Tutors");
       Person uInfo = new Person();
            uInfo.setName(databaseReference.child().child("Name").getValue(Person.class).getName());
            uInfo.setDescription( databaseReference.child().child("Description").getValue(Person.class).getDescription());
            uInfo.setLocation( databaseReference.child().child("Location").getValue(Person.class).getLocation());
            uInfo.setEmail( databaseReference.child().child("Email").getValue(Person.class).getEmail());


            ArrayList<String> array = new ArrayList<>();
            array.add(uInfo.getName());
            array.add(uInfo.getDescription());
            array.add(uInfo.getLocation());
            array.add(uInfo.getEmail());
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,array);
            listView.setAdapter(adapter);
        }
*/