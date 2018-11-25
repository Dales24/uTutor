package com.dan.ututor.System;

public class TutorElement {
    private String name;
    private String description;

    public TutorElement( String name, String description) {

        this.name = name;
        this.description=description;
    }

    public String getName(){return name;}


    public String getDescription(){return description;}
    public void setName(String Name){this.name=name;}


    public void setDescription(String description){this.description=description;}
}
