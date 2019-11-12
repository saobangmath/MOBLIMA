package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 Represents a student enrolled in the school.
 A student can be enrolled in many courses.
 @author Tran Anh Tai
 @version 1.0
 @since 2010-10-15
 */
public class Admin{
    /**
     Admin corresponding variables
     */
    private String username,name, password, email;
    /**
     different Admin constructors
     */
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    public Admin(String username, String password, String name){
        this(username, password);
        this.name = name;
    }
    public Admin(String username, String password, String name, String email){
        this(username, password, name);
        this.email = email;
    }
    /**
     Admin getAccessing to variable methods
     */
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }
}
