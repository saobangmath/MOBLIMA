package Models;

import java.io.Serializable;
import java.util.Scanner;
/**
 Represents a student enrolled in the school.
 A student can be enrolled in many courses.
 @author Tran Anh Tai
 @version 1.0
 @since 2010-10-15
 */
public class Admin implements Serializable {
    /**
     Admin corresponding variables
     */
    private String username,name, password, email;
    /**
     different Admin constructors
     */
    public Admin(String name, String password){
        this.name = name;
        this.password = password;
    }
    public Admin(String name, String password, String username){
        this(name, password);
        this.username = username;
    }
    public Admin(String name, String password, String username, String email){
        this(name, password, username);
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
    /**
     Admin functionalities
     */
    public void SystemConfiguration() {
        System.out.println("Sys config");
        //TODO configuration ticket price, holidays,..
    }

    public void CinemaShowTime() {
        System.out.println("Cinema Showtime");
        //TODO create/update/remove cinema showtimes and movie to be show - required Movie and Cinema class
    }

    public void MovieListing() {
        System.out.println("Movie Listing");
        //TODO create/update/remove Movie lists - required Movie class
    }
    public void showTop5ByTicketSales(){
        // TODO show top 5 movies have most ticket sales
    }
    public void showTop5ByReviewRating(){
        // TODO show to 5 movies with most ok reviews from the users
    }
}
