package com.oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class dbconnct {
	public static Connection connect()
    {
        Connection dbcon =null;
        
        try {
        Class.forName("com.mysql.jdbc.Driver");
        dbcon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/resmanagementsytem","root","");
        
        
        } 
        catch (Exception e) {
            
            System.out.println(e);
        }
        
        
        
        return dbcon;
    }
}
