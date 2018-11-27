
        package com.dan.ututor.System;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import com.dan.ututor.R;
      import  android.content.Context;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.ChildEventListener;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.google.firebase.database.ValueEventListener;
        import android.widget.AdapterView;
	import android.view.LayoutInflater;
        import android.widget.AdapterView.OnItemSelectedListener;
        import 	java.util.ArrayList;
        import 	android.widget.ArrayAdapter;
        import android.widget.TextView;
        import android.widget.Spinner;
        import android.widget.Toast;
import com.dan.ututor.System.TutorElement;
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
    private FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseReferenceRelation;
    ArrayList<TutorElement> array = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        major = (Spinner) findViewById(R.id.spinner1);
        listView = findViewById(R.id.listView);
        mAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference().child("Tutors");
        databaseReferenceRelation = firebaseDatabase.getInstance().getReference().child("Relation");
        final yourAdapter adapter = new yourAdapter(this,array);



        listView.setAdapter(adapter);
      //  listView.setAdapter(adapter);


       major.setOnItemSelectedListener(new OnItemSelectedListener() {
           @Override
           public void onNothingSelected(AdapterView<?> arg0) {

           }

           @Override
           public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

               final String major2   = major.getSelectedItem().toString();

               System.out.println("LOG:  major2 - " + major2);
               array.clear();
               adapter.notifyDataSetChanged();

               databaseReference.orderByChild("Major").equalTo(major2).addChildEventListener(new ChildEventListener() {
                   @Override
                   public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                       String name = dataSnapshot.child("Name").getValue(String.class);
//                       String email = dataSnapshot.child("Email").getValue(String.class);
                       String descript = dataSnapshot.child("Description").getValue(String.class);
                       String email = dataSnapshot.child("Email").getValue(String.class);
                       System.out.println("ErrorSS:  " + dataSnapshot);
                       //  String value = dataSnapshot.getValue(String.class);
                      TutorElement tutor = new TutorElement(name, descript,email);
                     array.add(tutor);
                       adapter.notifyDataSetChanged();
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

               });

           }
           });

        }
       }

     class yourAdapter extends BaseAdapter {

            Context context;
            ArrayList<TutorElement> data;
            private static LayoutInflater inflater = null;

            public yourAdapter(Context context,ArrayList<TutorElement> data) {

                this.context = context;
                this.data = data;
                inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
         @Override
         public int getCount() {

             return data.size();
         }

         @Override
         public Object getItem(int position) {

             return data.get(position);
         }

         @Override
         public long getItemId(int position) {

             return position;
         }


         @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View vi = convertView;
             Button button;
                if (vi == null)
                    vi = inflater.inflate(R.layout.activity_listelement, null);
                final TextView text = (TextView) vi.findViewById(R.id.name);
             TextView text2 = (TextView) vi.findViewById(R.id.description);
             final  TextView text3 = (TextView) vi.findViewById(R.id.email);
             text3.setText(data.get(position).getEmail());
                text.setText(data.get(position).getName());
                text2.setText(data.get(position).getDescription());
             button = vi.findViewById(R.id.button);
             button.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                //     if (mAuth.getCurrentUser() != null) {
                //         String user_id = mAuth.getCurrentUser().getUid();
            /*         String email =text3.toString();
                     String[] TO = {email};
                     String[] CC = {"xyz@gmail.com"};
                     Intent emailIntent = new Intent(Intent.ACTION_SEND);
                     emailIntent.setData(Uri.parse("mailto:"));
                     emailIntent.setType("text/plain");


                     emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                     emailIntent.putExtra(Intent.EXTRA_CC, CC);
                     emailIntent.putExtra(Intent.EXTRA_SUBJECT, "uTutor");
                     emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello I would like to be tutored");

                     try {
                         startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                         finish();
                         Log.i("Finished sending email...", "");
                     } catch (android.content.ActivityNotFoundException ex) {
                         Toast.makeText(MainActivity.this,
                                 "There is no email client installed.", Toast.LENGTH_SHORT).show();
                     }
                 }*/

                     }
                // }


             });
             return vi;

         }
     }

