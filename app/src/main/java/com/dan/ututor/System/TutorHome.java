package com.dan.ututor.System;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class TutorHome {

// pass profiles from database to array
     String[] profiles;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_home);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("https://capstone-71d9c.firebaseio.com/Tutor");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value  = dataSnapshot.getValue(String.class);
// need conditions
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })


        ListView listView = (ListView)findViewByID(R.id.listView);

    }

    class CustomAdapter extends BaseAdapter{
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

