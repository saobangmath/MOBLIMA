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

    public static void readDB(){
        /**
         * read the Admin database store in the list to a local Arraylist for other method using
         */
        AdminList = AdminDB.readData();
    }

    public static void saveDB(){
        /**
         * override the AdminList to the file storing Admin details
         */
        AdminDB.saveData(AdminList);
    }

    public static boolean isAuthenticate(String username, String password){
        /**
         * for login the admin into the system configuration
         */
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

    public static void addMovie(Movie movie){
        /**
         * adding the new movie into the movie database if does not exist
         */
        if (MovieController.checkExist(movie.getID())){
            System.out.println("The movieID have existed in the database!");
            return;
        }
        else{
            MovieController.create(movie);
            System.out.println("The film is added successfully!");
        }
    }

    public static void deleteMovie(int movieID) {
        /**
         * deleting a movie in the movie database if exist
         */
        if (MovieController.delete(movieID)){
            System.out.println("The film is successfully removed!");
        }
        else{
            System.out.println("The film is not existed in our database!");
        }
    }

    public static void topFiveByRating(){
        /**
         * display top 5 movie by its rating descending
         */
        MovieController.topFiveByRating();
    }

    public static void topFiveByTicket(){
        /**
         * display top 5 movie by its tickets sales descending
         */
        MovieController.topFiveByTicket();
    }
}
