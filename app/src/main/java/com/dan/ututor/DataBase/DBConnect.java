package com.dan.ututor.DataBase;

import java.sql.*;
class DBConnect{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "ututor.apgts.com:3306","ututor_db","Q^V12_NnEs0L");
//here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}  