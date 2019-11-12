package controller;

import database.HistoryBookingDB;
import database.MovieDB;
import model.Admin;
import database.AdminDB;
import model.Movie;

import java.util.ArrayList;


public class AdminController {
    private static ArrayList<Admin> AdminList;

    public static void readDB(){
        AdminList = AdminDB.readData();
    }

    public static void saveDB(){
        AdminDB.saveData(AdminList);
    }

    public static boolean IsAuthentication(String username, String password){
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

    public static void AddMovie(String nameInput, int movieID, String category,
                                String description, String director, String cast,
                                int restriction, String startDate, String endDate, int duration){
        if (MovieController.checkExist(movieID)){
            System.out.println("The movieID have existed in the database!");
            return;
        }
        else{
            Movie movie = new Movie(nameInput,
                    movieID, category,
                    description,
                    director,
                    cast,
                    restriction,
                    0,
                    startDate,
                    endDate,
                    duration
            );
            MovieController.create(movie);
            System.out.println("The film is added successfully!");
        }
    }

    public static void DeleteMovie(int movieID) {
        if (MovieController.checkExist(movieID)){
            MovieController.delete(movieID);
            System.out.println("The film is successfully removed!");
        }
        else{
            System.out.println("The film is not existed in our database!");
        }
    }

    public static void TopFiveMovieRankByRatings(){

        MovieController.DisplayByTopFiveByRating();
    }

    public static void TopFiveMovieRankByTicketsSale(){

        MovieController.DisplayByTopFiveByTicketSale();
    }
}
