package controller;

import database.HistoryBookingDB;
import model.Admin;
import database.AdminDB;
import model.Review;

import java.util.ArrayList;

public class AdminController {
    private ArrayList<Admin> AdminList = new ArrayList<Admin>();
    private ArrayList<Review>ReviewList = new ArrayList<>();

    private AdminDB db = new AdminDB();
    private HistoryBookingDB histDB = new HistoryBookingDB();

    public AdminController(){
        this.AdminList = db.readData();
        this.ReviewList = histDB.readData();
    }

    public boolean IsAuthentication(String username, String password){
        boolean authenticate = false;
        for (int i = 0; i < this.AdminList.size(); i++){
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
    public void SystemConfiguration(){

    }
    public void DisplayTopFiveMovieRankByRatings(){

    }
    public void DisplayTopFiveMovieRankByTicketsSale(){

    }
    public void ViewHistoryBooking(){
        for (int i = 0; i < ReviewList.size(); i++){
            Review review = ReviewList.get(i);
            System.out.println(" FilmID: " + review.getMovieID()
                             + " FilmName: " + review.getMovieName()
                             + " of user: " + review.getEmail()
                             + " with comment: " + review.getComment());
        }
    }
}
