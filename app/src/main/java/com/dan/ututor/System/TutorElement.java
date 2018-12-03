package com.dan.ututor.System;

public class TutorElement {
    private String name;
    private String description;
    private String email;
    private String UID;
    public TutorElement( String name, String description, String email, String UID) {
        this.UID = UID;
        this.name = name;
        this.description=description;
        this.email=email;
    }

    public String getName(){return name;}

    public String getUID(){return UID;}

    public void setUID(String UID){this.UID=UID;}

    public String getDescription(){return description;}
    public void setName(String name){this.name=name;}
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {this.email = email;}
    public void setDescription(String description){this.description=description;}
}
