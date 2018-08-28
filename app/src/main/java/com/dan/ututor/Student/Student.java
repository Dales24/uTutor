package com.dan.ututor.Student;

public class Student {

    private String email;
    private String password;
    private int ID;
    public int name;
    public Student() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Student(String email, String password, int ID) {
        this.email = email;
        this.password = password;
        this.ID=ID;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
