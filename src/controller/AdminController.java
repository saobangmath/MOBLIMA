package controller;

import model.Admin;
import database.AdminDB;
import model.Movie;

import java.util.ArrayList;

/**
 * Represents all operations related to Admin object
 * @author Tran Anh Tai
 */
public class AdminController {
    private static ArrayList<Admin> AdminList;
    /**
     * read the Admin database store in the list to a local Arraylist for other method using
     */
    public static void readDB(){
        AdminList = AdminDB.readData();
    }
    /**
     * override the AdminList to the file storing Admin details
     */
    public static void saveDB(){
        AdminDB.saveData(AdminList);
    }
    /**
     * for login the admin into the system configuration
     */
    public static boolean isAuthenticate(String username, String password){
        boolean authenticate = false;
        for (int i = 0; i < AdminList.size(); i++){
            Admin ad = AdminList.get(i);
            if (username.equals(ad.getUsername()) && password.equals(ad.getPassword())){
                authenticate = true;
                break;
            }
        }
        if (!authenticate){
            System.out.println("You are not an admin yet! Please re-enter your choice");
        }
        return authenticate;
    }

}
