package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {
    private int CineplexID;
    private String location;
    ArrayList<Cinema> availableMovies =  new ArrayList<Cinema>();
    public Cineplex(int CineplexID, String location, ArrayList<Cinema>availableMovies){
        this.CineplexID = CineplexID;
        this.location = location;
        this.availableMovies = availableMovies;
    }

    public int getCineplexID() {
        return this.CineplexID;
    }

    public String getLocation() {
        return this.location;
    }

    public ArrayList<Cinema> getAvailableMovies() {
        return this.availableMovies;
    }


}
