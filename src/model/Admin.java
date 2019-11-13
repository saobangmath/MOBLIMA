package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *Represents Admin object
 *@author Tran Anh Tai
 */
public class Admin{
    private String username,name, password, email;

    /**
     *different set of Admin constructors for various usage
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
     * get the admin name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * get the admin password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * get the admin email
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * get the admin username
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
}
