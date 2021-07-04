package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cloudy
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static Connection cn;
   public static int id;
   public static String firstname;
   public static String lastname;
   public static String email;
   public static String phone;
   public static Connection getConnection(){
       try {
           Class.forName("com.mysql.jdbc.Driver");
           cn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", ""); 
           return cn;
       } catch (ClassNotFoundException | SQLException ex) {
           System.out.println(ex);
       }
       return null;
   }
          
}

