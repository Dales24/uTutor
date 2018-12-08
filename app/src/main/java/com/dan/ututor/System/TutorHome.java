package com.dan.ututor.System;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.dan.ututor.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class TutorHome extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference2;
    FirebaseDatabase firebaseDatabase;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_home);
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

                        System.out.println("testing " + sName);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }
