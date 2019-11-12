package controller;

import database.HistoryBookingDB;
import database.MovieDB;
import model.Admin;
import database.AdminDB;
import model.Movie;

import java.util.ArrayList;


public class AdminController {
    private static ArrayList<Admin> AdminList;
    private static ArrayList MovieList;


    public static void readDB(){
        AdminList = AdminDB.readData();
        MovieList = MovieDB.readData();
    }

    public static void saveDB(){
        AdminDB.saveData(AdminList);
        MovieDB.saveData(MovieList);
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
        if (checkExist(movieID)){
            System.out.println("The movieID have existed in the database!");
            return;
        }
        else{
            MovieList.add(new Movie(nameInput,
                                movieID, category,
                                description,
                                director,
                                cast,
                                restriction,
                                0,
                                startDate,
                                endDate,
                                duration
                                ));
            System.out.println("The film is added sucessfully!");
        }
    }

    private static boolean checkExist(int movieID) {
        for (int i = 0; i < MovieList.size(); i++){
            if (((Movie)MovieList.get(i)).getID() == movieID){
                return true;
            }
        }
        return false;
    }

    public static void TopFiveMovieRankByRatings(){

        MovieController.DisplayByTopFiveByRating();
    }

    public static void TopFiveMovieRankByTicketsSale(){

        MovieController.DisplayByTopFiveByTicketSale();
    }

    public static void DeleteMovie(int movieID) {
        for (int i = 0; i < MovieList.size(); i++){
            if (((Movie)MovieList.get(i)).getID() == movieID){
                MovieList.remove(i);
                System.out.println("The film is successfully removed in the database!");
                return;
            }
        }
        System.out.println("The film is not existed in our database!");
    }
}
