/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import utils.DbConnection;
/**
 *
 * @author Cloudy
 */
public class User {
   public int id;
   public String firstname;
   public String lastname;
   public String email;
   public String phone;
   Connection cn;

    public User() {
        
        cn = DbConnection.getConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void saveUser(User u) {
        String sql = "INSERT INTO addressbook (firstname,lastname,email,phone) VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, u.getFirstname());
            ps.setString(2, u.getLastname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());
            ps.execute();
        } catch (SQLException ex) {
        }
    }
    
    public ResultSet getUsers() {
        String sql = "SELECT * FROM addressbook";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
           
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public void deleteUser(String name) {
        String firstname = name.split(",")[1];
        String lastname = name.split(",")[0];
        String sql = "DELETE FROM addressbook WHERE firstname=? AND lastname=?";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    
    public ResultSet findUser(String firstname) {
        String sql = "SELECT * FROM addressbook WHERE (firstname LIKE ?) ";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + firstname + "%");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch(SQLException ex) {
        }
        return null;
    }    
}
