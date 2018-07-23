package com.dan.ututor.Student;

public class Tutor {

    private String email;
    private String password;
    private int ID;

    public Tutor() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Tutor(String email, String password, int ID) {
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
