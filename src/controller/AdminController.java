package controller;

import database.HistoryBookingDB;
import database.MovieDB;
import model.Admin;
import database.AdminDB;
import model.Booking;
import model.Movie;

import java.util.ArrayList;
import java.util.Collections;

public class AdminController {
    private static ArrayList<Admin> AdminList;
    private static ArrayList<Booking> BookingList;
    private static ArrayList<Movie> MovieList;
    private static AdminDB db = new AdminDB();
    private static HistoryBookingDB histDB = new HistoryBookingDB();
    private static MovieDB movieDB = new MovieDB();
    private static MovieController movieController = new MovieController();

    public AdminController(){
        this.AdminList = db.readData();
        this.BookingList = histDB.readData();
        this.MovieList = movieDB.readData();
        this.movieController = new MovieController();
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
    public static void AddMovie(){

    }
    public static void TopFiveMovieRankByRatings(){
        Collections.sort(MovieList, new MovieController.SortByRating());
        int movieID = 0;
        while (movieID < Math.min(5, MovieList.size())){
            System.out.println("ID: "+ MovieList.get(movieID).getID());
            System.out.println("Name: " + MovieList.get(movieID).getName());
            System.out.println("Category: "+ MovieList.get(movieID).getCategory() );
            System.out.println("Description: "+ MovieList.get(movieID).getDescription() );
            System.out.println("Director: "+ MovieList.get(movieID).getDirector() );
            System.out.println("Cast: "+ MovieList.get(movieID).getCast() );
            System.out.println("Restriction: "+ MovieList.get(movieID).getRestriction() );
            System.out.println("Overall Rating: "+ MovieList.get(movieID).getOverallRating() );
            System.out.println("Start Dtae: "+ MovieList.get(movieID).getStartDate());
            System.out.println("End Date: "+ MovieList.get(movieID).getEndDate());
            System.out.println("\n");
             movieID++;
        }
    }
    public static void TopFiveMovieRankByTicketsSale(){

    }

    public static ArrayList<Booking> GetAllBooking(){
        return BookingList;
    }
}
