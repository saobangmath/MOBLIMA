package Models;

import java.io.Serializable;
import java.util.Scanner;

public class Admin implements Serializable {
    private String username,name, password, email;
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

    public void SystemConfiguration() {
        System.out.println("Sys config");
        //TODO configuration the figure - what should be configure here ? :v
    }

    public void CinemaShowTime() {
        System.out.println("Cinema Showtime");
        //TODO create/update/remove cinema showtimes and movie to be show - required Movie and Cinema class
    }

    public void MovieListing() {
        System.out.println("Movie Listing");
        //TODO create/update/remove Movie lists - required Movie class
    }
}
