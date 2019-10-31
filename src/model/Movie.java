package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int MovieID, rating;
    private String MovieName,Description, Restriction, Category;
    public Movie(int MovieID){
        this.MovieID = MovieID;
    }
    public Movie(int MovieID, String MovieName, String Description){
        this(MovieID);
        this.MovieName = MovieName;
        this.Description = Description;
        this.rating = 5 - MovieID; // TODO need to be update through the time
    }
    public Movie(int MovieID, String MovieName, String Description, String Category){
        this(MovieID,MovieName,Description);
        this.Category = Category;
    }

    public int getMovieID() {
        return this.MovieID;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getMovieName() {
        return this.MovieName;
    }

    public String getRestriction() {
        return this.Restriction;
    }

    public int getRating() {
        return this.rating;
    }
}
