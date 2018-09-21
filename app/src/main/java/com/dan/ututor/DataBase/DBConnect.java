package com.dan.ututor.DataBase;

import java.sql.*;
public class DBConnect{
    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9235287", "sql9235287", "kL4qWu22zx");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser Person = mAuth.getCurrentUser();
        String userId = Person.getUid();
        DatabaseReference mRef = database.getReference().child("Person").child(userId);
        mRef.child("age").setValue(age);
        mRef.child("school").setValue(school);
        mRef.child("firstName").setValue(firstName);
        mRef.child("lastName").setValue(lastName);
        mRef.child("location").setValue(location);
        mRef.child("description").setValue(description);
        mRef.child("gpa").setValue(gpa);
        mRef.child("rating").setValue(rating);
        mRef.child("online").setValue(online);
        mRef.child("email").setValue(email);
        mRef.child("password").setValue(password);

    }


}  