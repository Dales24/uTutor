package com.dan.ututor.Student;

public class Person {

        private String email;
        private String password;
      //  private int id;
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

        public Person(String email, String password, int ID) {
            this.email = email;
            this.password = password;
    //        this.id=id;
        }

    //    public int getID() {
     //       return id;
     //   }

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

     //   public void setID(int id) {this.id= id;}

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


}
/* if(logged in){
online=true;
}
*/

