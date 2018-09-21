package com.dan.ututor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dan.ututor.System.Student;
import com.dan.ututor.System.Person;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Log extends AppCompatActivity {

    //declare DB
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClicked(View view){

        //Retrieve data from login page and convert to strings
        EditText rawPass = findViewById(R.id.passwordInput);
        String stringPass = rawPass.getText().toString();

        EditText rawEmail = findViewById(R.id.emailInput);
        String stringEmail = rawEmail.getText().toString();

        //init DB
        dbRef = FirebaseDatabase.getInstance().getReference();

        //execute insertion of new user
        int ID=10000;
        Student st = new Student("test@gmail.com","pass1234",ID);
        dbRef.child("Students").child(Integer.toString(ID)).setValue(st);

        ID=10001;
        st = new Student("test1@gmail.com","pass9999",ID);
        dbRef.child("Students").child(Integer.toString(ID)).setValue(st);

        ID=10002;
        Person tu = new Person("tes2@gmail.com","passxxx",ID);
        dbRef.child("Tutors").child(Integer.toString(ID)).setValue(tu);

        ID=10003;
        tu = new Person("test3@gmail.com","passyyy",ID);
        dbRef.child("Tutors").child(Integer.toString(ID)).setValue(tu);

// writing to the database
        
        private void writeNewUser(int age, String school, String firstName, String lastName, String location,
                String description,double gpa, int rating,boolean online, String email, String password) {
            Person person = new Person(age, school, email, lastName, location, description, gpa, rating, online, password);
            mDatabase.child("person").child(userId).setValue(user);
        }
        //update user profile
        private void updateUserEmail(int age, String school, String firstName, String lastName, String location,
                String description,double gpa, String email, String password) {

        }
        //update user profile rating
        private void updateUserRating(int rating) {

        }

        //update user profile status
        private void updateUserStatus(int online) {

        }
        //resetting a user email
        private void updateUserEmail(String email, String password) {

        }
    }
}
