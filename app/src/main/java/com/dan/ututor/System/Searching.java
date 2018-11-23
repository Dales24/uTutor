
        package com.dan.ututor.System;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ListView;
        import com.dan.ututor.R;
        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.google.firebase.database.ValueEventListener;
        import 	java.util.ArrayList;
        import 	android.widget.ArrayAdapter;
        import android.widget.Spinner;

        public class Searching extends AppCompatActivity {

    public String bio="Biology";
    public String math="Math";
    public String nursing="Nursing";
    public String communications="Communications";
    public String bus="Business";
    public String criminaljust="Criminal Justice";
    public String sportssci="Sports Science";
    public String english="English";
    public String history="History";
            public String comsci="Computer Science";
    ListView listView;
    private Spinner major;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> array = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        major = (Spinner) findViewById(R.id.spinner1);
        listView = findViewById(R.id.listView);

        databaseReference = firebaseDatabase.getInstance().getReference().child("Tutors");
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,array);
        listView.setAdapter(adapter);
  final String major2   = major.getSelectedItem().toString();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

             if(major2.equals(bio)){
                String name = dataSnapshot.child("Name").getValue(String.class);
                String  email= dataSnapshot.child("Email").getValue(String.class);
                String  descript= dataSnapshot.child("Description").getValue(String.class);
                //  String value = dataSnapshot.getValue(String.class);
                array.add(name);
                array.add(email);
                array.add(descript);
                adapter.notifyDataSetChanged();}

              else  if(major2.equals(english)){
                String name = dataSnapshot.child("Name").getValue(String.class);
                String  email= dataSnapshot.child("Email").getValue(String.class);
                String  descript= dataSnapshot.child("Description").getValue(String.class);
                //  String value = dataSnapshot.getValue(String.class);
                array.add(name);
                array.add(email);
                array.add(descript);
                adapter.notifyDataSetChanged();}

              else  if(major2.equals(communications)){
                    String name = dataSnapshot.child("Name").getValue(String.class);
                    String  email= dataSnapshot.child("Email").getValue(String.class);
                    String  descript= dataSnapshot.child("Description").getValue(String.class);
                    //  String value = dataSnapshot.getValue(String.class);
                    array.add(name);
                    array.add(email);
                    array.add(descript);
                    adapter.notifyDataSetChanged();


             }
              else  if(major2.equals(criminaljust)){
                    String name = dataSnapshot.child("Name").getValue(String.class);
                    String  email= dataSnapshot.child("Email").getValue(String.class);
                    String  descript= dataSnapshot.child("Description").getValue(String.class);
                    //  String value = dataSnapshot.getValue(String.class);
                    array.add(name);
                    array.add(email);
                    array.add(descript);
                    adapter.notifyDataSetChanged();}
            else if(major2.equals(comsci)){
                    String name = dataSnapshot.child("Name").getValue(String.class);
                    String  email= dataSnapshot.child("Email").getValue(String.class);
                    String  descript= dataSnapshot.child("Description").getValue(String.class);
                    //  String value = dataSnapshot.getValue(String.class);
                    array.add(name);
                    array.add(email);
                    array.add(descript);
                    adapter.notifyDataSetChanged();}
        }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });}}


