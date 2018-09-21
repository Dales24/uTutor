package com.dan.ututor.System;

import android.media.Rating;

public class Person {

        private String email;
        private String password;
       private int id;
        private String school;
        private int age;
        private String firstName;
        private String lastName;
        private String location;
        private String description;
        private double gpa;
        private int rating;
        private boolean online;
        public Person() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }
        //constructor for setting up profile info
public Person(String email, String password, String school, int age, String firstName,String lastName,
              String location, String description, double gpa){
    this.email=email;
    this.password=password;
    this.school=school;
    this.age=age;
    this.firstName= firstName;
    this.lastName=lastName;
    this.location=location;
    this.description=description;
    this.gpa=gpa;

}
// resetting email and password
    public Person(String email, String password) {
        this.email = email;
        this.password = password;
        }

// updating user rating from others
public Person(int rating){
          this.rating=rating;
}

//setting online status
    public Person(boolean online){
        this.online=online;
    }



        public Person(String email, String password, int ID) {
            this.email = email;
            this.password = password;
             this.id=id;
        }

        public int getRating(){return rating;}

        public boolean getOnline() {
        return online;
    }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getSchool(){return school;}

        public int getAge(){return age;}

        public double getGPA(){return gpa;}

        public String getFirstName(){return firstName;}

        public String getLastName(){return lastName;}

        public String getDescription(){return description;}

        public String getLocation(){return location;}

        public void setID(int id) {this.id= id;}

        public void setEmail(String email) {this.email = email;}

        public void setPassword(String password) {
        this.password = password;
    }

        public void setSchool(String school){ this.school = school;}

        public void setAge(int age){  this.age = age;}

        public void setGPA(double gpa){this.gpa=gpa;}

        public void setFirstName(String firstName){this.firstName=firstName;}

        public void setLastName(String lastName){this.lastName=lastName;}

        public void setDescription(String description){this.description=description;}

        public void setLocation(String location){this.location=location;}

        public void setOnline(boolean online){  this.online = online;}


       public int getID() {
          return id;
       }


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


